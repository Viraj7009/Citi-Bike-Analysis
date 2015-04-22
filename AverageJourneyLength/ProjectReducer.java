import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ProjectReducer extends Reducer<Text, IntWritable, Text, LongWritable> 
{
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException 
	{
		long count = 0, sum = 0;
		for(IntWritable i : values){
			count += 1;
			sum += i.get();
		}
		
		long avg = sum/count;
		context.write(key, new LongWritable(avg));
	}
}