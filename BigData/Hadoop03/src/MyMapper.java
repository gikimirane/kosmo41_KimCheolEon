import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	// 출력값
	private final static IntWritable one = new IntWritable(1);

	// 출력키
	private Text word = new Text();

	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {

		StringTokenizer st = new StringTokenizer(value.toString());
		while (st.hasMoreTokens()) {
			word.set(st.nextToken());	// 출력키 설정
			context.write(word, one);	// 출력 데이터 생성
		}

	}
}
