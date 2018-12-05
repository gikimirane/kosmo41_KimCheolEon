import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer 
	extends Reducer<Text, IntWritable, Text, IntWritable> {

	private IntWritable result = new IntWritable();

	// <key, list> 를 <key, value>로 합치는 과정
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();	// 리스트를 합산하는 과정
		}
		
		result.set(sum);			// 출력키 설정
		context.write(key, result);	// 출력 데이터 생성

	}

}
