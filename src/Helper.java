import java.io.IOException;
import java.net.URI;
import java.util.TimerTask;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Helper  extends TimerTask{
	public static int i=0;
	
	@Override
    public void run() {
        String localpath="/home/pelatro/eclipse-workspace/Server/src/user.csv";
        String localpath1="/home/pelatro/eclipse-workspace/Server/src/address.csv";
        String localpath2="/home/pelatro/eclipse-workspace/Server/src/orders.csv";
        
        String uri="hdfs://localhost:9000";
        
        String hdfsDir="hdfs://localhost:9000/user/pelatro/db/useroutput.csv";
        String hdfsDir1="hdfs://localhost:9000/user/pelatro/db/addressoutput.csv";
        String hdfsDir2="hdfs://localhost:9000/user/pelatro/db/orderoutput.csv";
        
        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://localhost:9000");
        FileSystem fs = null;
        try {
			fs = FileSystem.get(URI.create(uri), conf);
			fs.copyFromLocalFile(new Path(localpath), new Path(hdfsDir));
			fs.copyFromLocalFile(new Path(localpath1), new Path(hdfsDir1));
			fs.copyFromLocalFile(new Path(localpath2), new Path(hdfsDir2));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		}
    }
}
