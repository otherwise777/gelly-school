/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package flink.gelly.school;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.graph.Edge;
import org.apache.flink.graph.EdgeDirection;
import org.apache.flink.graph.Graph;
import org.apache.flink.graph.ReduceEdgesFunction;
import org.apache.flink.graph.Vertex;
import org.apache.flink.graph.library.PageRankAlgorithm;

/**
 * This is the skeleton for the Gellyschool training task "PageRank on ReplyGraph".
 * 
 * The task is to create a Graph from Apache Flink mailing list data,
 * calculate the transition probabilities (edge weights), and run the
 * Gelly library method {@link org.apache.flink.graph.library.PageRankAlgorithm}
 * on the weighted Graph.
 * <p>
 * The edges input file is expected to contain one edge per line, with String IDs and double
 * values in the following format:"sourceVertexID \t targetVertexID \t weight".
 * <p>
 * The library algorithm takes as input parameters the dampening factor (usually set to 0.85)
 * and the number of iterations to run.
 * <p>
 * Required parameters:
 *   --input path-to-input-directory
 *   --output path-to-output-directory
 * <p>
 * Optional parameters:
 *   --numIterations the number of iterations to run (default value: 10)
 */
public class PageRankWithEdgeWeights {
	
	private static final double DAMPENING_FACTOR = 0.85;
	private static String input = null;
	private static String output = null;
	private static int numIterations = 10;

	public static void main(String[] args) throws Exception {
	
		// parse parameters
		ParameterTool params = ParameterTool.fromArgs(args);
		input = params.getRequired("input");
		output = params.getRequired("output");
		numIterations = params.getInt("numIterations", 10);

		ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

		// read the Edge DataSet from the input file
		// DataSet<Tuple3<String, String, Double>> links = env.readCsvFile(input) ...
				// set the field and line delimiters
				// set the field types


		// create a Graph with vertex values initialized to 1.0 (the initial rank)
//		Graph<String, Double, Double> network = Graph.fromTupleDataSet(links,
//				new MapFunction<String, Double>() {
//					...
//				}, env);

		// for each vertex calculate the total weight of its outgoing edges
		// hint: use the {@link org.apache.flink.graph.Graph#reduceOnEdges} method
//		DataSet<Tuple2<String, Double>> sumEdgeWeights = ...

		// assign the transition probabilities as edge weights:
		// divide edge weight by the total weight of outgoing edges for that source
		// hint: use the {@link org.apache.flink.graph.Graph#joinWithEdgesOnSource} method
//		Graph<String, Double, Double> networkWithWeights = ...

		// run the Page Rank algorithm on the weighted graph
//		DataSet<Vertex<String, Double>> pageRanks = networkWithWeights.run(
//				new PageRankAlgorithm<String>(...))...

		// write the output and execute the program
//		pageRanks.writeAsCsv(...);
		env.execute();

	}
	
	// This neighborhood function calculates the total weight of outgoing edges for a vertex
//	static final class SumWeight implements ReduceEdgesFunction<Double> {
//	
//		@Override
//		public Double reduceEdges(Double firstEdgeValue, Double secondEdgeValue) {
//			...
//		}
//	}

}
