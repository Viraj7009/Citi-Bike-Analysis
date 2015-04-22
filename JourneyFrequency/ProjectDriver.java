import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ProjectDriver 
{
	public static void main(String[] args) throws Exception 
	{
		Configuration conf = new Configuration();
        conf.set("mapreduce.output.textoutputformat.separator", " ");
        
		if (args.length != 2) 
		{
			System.err.println("Usage: ProjectDriver <input path> <output path>");
			System.exit(-1);
		}
		Job job = new Job(conf);
		job.setJarByClass(ProjectDriver.class);
		job.setJobName("CitiBikeAnalysis");
		String input = args[0], output = args[1];
		
		FileInputFormat.addInputPath(job, new Path(input));
		FileOutputFormat.setOutputPath(job, new Path(output));

		job.setMapperClass(ProjectMapper.class);
		job.setReducerClass(ProjectReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.waitForCompletion(true);
		
	}
}

