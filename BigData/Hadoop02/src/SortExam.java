import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;



public class SortExam {

	public static void main(String[] args) throws Exception {

		// 파라미터가 2개가 아니면 강제 종료
		if (args.length != 2) {
			System.out.println("Usage : HdfsExam <input> <output>");
			System.exit(-1);
		}
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "SortExam");
		
		// job class 이름
		job.setJarByClass(SortExam.class);
		
		// 기본 mapper, 입력 레코드가 그대로 출력 레코드가 됨.
		job.setMapperClass(Mapper.class);
		
		// 기본 reducer, 맵의 출력 레코드가 그대로 리듀스의 출력이 됨.
		// reduce 단계에서 내부적으로 sort 가 처리됨
		job.setReducerClass(Reducer.class);
		
		//맵 출력과 리듀스 출력의 key, value 자료형
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		// reduce 의 수를 1로 설정 : 레코드 갯수가 줄어들지 않음.
		job.setNumReduceTasks(1);
		
		//입출력 파일의 형식지정
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		//입력 데이터 파일
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		//출력 디렉터리 지정 - 시퀀스 파일 형식으로
		SequenceFileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//블록 단위 압축 (60% 정도 사이즈 감소)
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);
		
		// 하둡 분석 작업 진행
		job.waitForCompletion(true);

	}

}
