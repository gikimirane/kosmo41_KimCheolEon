import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordCount {

	public static void main(String[] args) throws Exception {

		// 파라미터가 2개가 아니면 강제 종료
		if (args.length != 2) {
			System.out.println("Usage : WordCount <input> <output>");
			System.exit(-1);
		}

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "WordCount"); // job 이름

		// job class 이름
		job.setJarByClass(WordCount.class); // job class 이름
		job.setMapperClass(MyMapper.class); // mapper class 이름
		job.setReducerClass(MyReducer.class); // reducer class 이름

		// 입출력 데이터 형식 지정
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		// 출력키, 값 데이터 형식 지정
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// 입력 파일, 출력 디렉터리 지정
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// 하둡 분석 작업 진행
		job.waitForCompletion(true);

	}

}
