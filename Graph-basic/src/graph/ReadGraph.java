package graph;

import java.io.*;

/**
 * 读取 Graph 的类
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/26 22:16
 */
public class ReadGraph<T extends Graph> {

    public static final String GRAPH_TEXT_DIR = File.separator + "graph" + File.separator + "text" + File.separator;

    public ReadGraph(T t, String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(GRAPH_TEXT_DIR + filePath);
            InputStreamReader InputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(InputStreamReader);

            String line = reader.readLine();
            String[] graphInfo = line.split(" ");
            if (t.getNumOfEdges() == Integer.valueOf(graphInfo[0])) {
                String graphLines = null;
                while ((line = reader.readLine()) != null) {
                    String[] graphContent = line.split(" ");
                    Integer v = Integer.valueOf(graphContent[0]);
                    Integer w = Integer.valueOf(graphContent[1]);
                    if (v < t.getNumOfNodes() && v >= 0 && w < t.getNumOfNodes() && w >= 0) {
                        t.addEdge(v, w);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
