import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DepartureDelayCount {

	public static void main(String[] args) throws Exception {

		// 파라미터가 2개가 아니면 강제 종료
		if (args.length != 2) {
			System.out.println("Usage : DepartureDelayCount <input path> <output path>");
			System.exit(-1);
		}

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "DepartureDelayCount"); // job 이름

		job.setJarByClass(DepartureDelayCount.class);
		job.setMapperClass(DepartureDelayCountMapper.class);
		job.setReducerClass(DelayCountReducer.class);

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
