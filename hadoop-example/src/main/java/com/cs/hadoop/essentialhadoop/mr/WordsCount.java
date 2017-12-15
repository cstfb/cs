package com.cs.hadoop.essentialhadoop.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * 这是统计单词个数的例子
 *
 */
public class WordsCount {
    public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] strings = value.toString().split(" ");
            for (String s : strings) {
                //将文本行放入key
                context.write(new Text(s), new IntWritable(1));
            }
        }
    }

    public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {

            int count = 0;
            for (IntWritable v : values) {
                count += v.get();
            }
            //输出key
            context.write(key, new IntWritable(count));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: wordcount <in> [<in>...] <out>");
            System.exit(2);
        }

        //先删除output目录
        rmr(conf, otherArgs[otherArgs.length - 1]);

        Job job = Job.getInstance(conf, "WordsCount");
        job.setJarByClass(WordsCount.class);

        job.setMapperClass(MyMapper.class);
        job.setCombinerClass(MyReducer.class);
        job.setReducerClass(MyReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        if (job.waitForCompletion(true)) {
            cat(conf, otherArgs[1] + "/part-r-00000");
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    /**
     * 删除指定目录
     *
     * @param conf
     * @param dirPath
     *
     * @throws IOException
     */
    private static void rmr(Configuration conf, String dirPath) throws IOException {
        boolean delResult = false;
//        FileSystem fs = FileSystem.get(conf);
        Path targetPath = new Path(dirPath);
        FileSystem fs = targetPath.getFileSystem(conf);
        if (fs.exists(targetPath)) {
            delResult = fs.delete(targetPath, true);
            if (delResult) {
                System.out.println(targetPath + " has been deleted sucessfullly.");
            } else {
                System.out.println(targetPath + " deletion failed.");
            }
        }
//        return delResult;
    }

    /**
     * 输出指定文件内容
     *
     * @param conf     HDFS配置
     * @param filePath 文件路径
     *
     * @return 文件内容
     *
     * @throws IOException
     */
    public static void cat(Configuration conf, String filePath) throws IOException {

//        FileSystem fileSystem = FileSystem.get(conf);
        InputStream in = null;
        Path file = new Path(filePath);
        FileSystem fileSystem = file.getFileSystem(conf);
        try {
            in = fileSystem.open(file);
            IOUtils.copyBytes(in, System.out, 4096, true);
        } finally {
            if (in != null) {
                IOUtils.closeStream(in);
            }
        }
    }
}
