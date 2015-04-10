import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProjectMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException 
	{
		//"tripduration","starttime","stoptime","start station id","start station name","start station latitude",
		//"start station longitude","end station id","end station name","end station latitude","end station longitude",
		//"bikeid","usertype","birth year","gender"

		String line = value.toString();
		String trip[] = line.split(",");
		
		String stop_station = trip[8].replace("\"", "");
		
		context.write(new Text(start_station), new IntWritable(1));
	}
}
