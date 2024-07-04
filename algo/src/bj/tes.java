package bj;
import java.io.*;
import java.util.*;

public class tes {

	public static void main(String[] args) {
		int[][] array = {
	            {0, 0, 2},
	            {0, 0, 3},
	            {9, 0, 0}
	        };
	        
	        int rows = array.length;
	        int cols = array[0].length;
	        int V = rows * cols; // 전체 노드 수
	        
	        // 그래프 생성
	        List<int[]>[] g = new List[V];
	        for (int i = 0; i < V; i++) {
	            g[i] = new ArrayList<>();
	        }
	        
	        // 배열을 순회하면서 각 노드의 상하좌우에 연결된 노드를 그래프에 추가
	        for (int r = 0; r < rows; r++) {
	            for (int c = 0; c < cols; c++) {
	                int node = r * cols + c; // 현재 노드 번호
	                
	                // 현재 노드의 배열 값
	                int currentValue = array[r][c];
	                
	                // 상하좌우 탐색
	                // 위
	                if (r > 0 && array[r - 1][c] != 0) {
	                    int neighbor = (r - 1) * cols + c; // 인접 노드 번호
	                    int cost = array[r - 1][c]; // 연결 비용은 배열 값
	                    g[node].add(new int[]{neighbor, cost});
	                }
	                // 아래
	                if (r < rows - 1 && array[r + 1][c] != 0) {
	                    int neighbor = (r + 1) * cols + c; // 인접 노드 번호
	                    int cost = array[r + 1][c]; // 연결 비용은 배열 값
	                    g[node].add(new int[]{neighbor, cost});
	                }
	                // 왼쪽
	                if (c > 0 && array[r][c - 1] != 0) {
	                    int neighbor = r * cols + (c - 1); // 인접 노드 번호
	                    int cost = array[r][c - 1]; // 연결 비용은 배열 값
	                    g[node].add(new int[]{neighbor, cost});
	                }
	                // 오른쪽
	                if (c < cols - 1 && array[r][c + 1] != 0) {
	                    int neighbor = r * cols + (c + 1); // 인접 노드 번호
	                    int cost = array[r][c + 1]; // 연결 비용은 배열 값
	                    g[node].add(new int[]{neighbor, cost});
	                }
	            }
	        }
	        
	        // 그래프 출력 (디버깅용)
	        for (int i = 0; i < V; i++) {
	            System.out.print(i + " -> ");
	            for (int j = 0; j < g[i].size(); j++) {
	                int[] edge = g[i].get(j);
	                System.out.print("(" + edge[0] + "," + array[edge[0] / cols][edge[0] % cols] + ")");
	                if (j < g[i].size() - 1) {
	                    System.out.print(",");
	                }
	            }
	            System.out.println();
	        }
	}

}
