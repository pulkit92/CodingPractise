package test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.InputStream;
import java.util.List;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Test1 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SubtreesAndPaths solver = new SubtreesAndPaths();
        solver.solve(1, in, out);
        out.close();
    }
}

class SubtreesAndPaths {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int N = in.nextInt();
        List<Integer>[] tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            tree[x].add(y);
            tree[y].add(x);
        }

        HeavyLightDecomposition hld = new HeavyLightDecomposition(tree);

        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            String cmd = in.next();
            switch (cmd) {
                case "add":
                    int t = in.nextInt() - 1;
                    int value = in.nextInt();
                    hld.addSubTree(t, value);
                    break;
                case "max":
                    int a = in.nextInt() - 1;
                    int b = in.nextInt() - 1;
                    out.println(hld.query(a, b));
                    break;
            }
        }
    }

    static class HeavyLightDecomposition {

        static int modifyOperation(int x, int y) {
            return x + y;
        }

        static int queryOperation(int leftValue, int rightValue) {
            return Math.max(leftValue, rightValue);
        }

        static int getNeutralDelta() {
            return 0;
        }

        static int getInitValue() {
            return 0;
        }

        static int getNeutralValue() {
            return Integer.MIN_VALUE;
        }

        static int joinValueWithDelta(int value, int delta) {
            return modifyOperation(value, delta);
        }

        static int joinDeltas(int delta1, int delta2) {
            return modifyOperation(delta1, delta2);
        }

        int[][] value;
        int[][] delta; // delta[i] affects value[i], delta[2*i+1] and delta[2*i+2]
        int[] t;

        List<Integer>[] tree;
        int[] size;
        int[] parent;
        int[] tin;
        int[] tout;
        int time;
        int[] path;
        int[] pathSize;
        int[] pathPos;
        int[] pathRoot;
        int[] firstPath;
        int[] lastPath;
        int pathCount;

        // T[i] += value
        static void add(int[] t, int i, int value) {
            for (; i < t.length; i |= i + 1)
                t[i] += value;
        }

        // sum[0..i]
        static int sum(int[] t, int i) {
            int res = 0;
            for (; i >= 0; i = (i & (i + 1)) - 1)
                res += t[i];
            return res;
        }

        // interval add
        static void add(int[] t, int a, int b, int value) {
            add(t, a, value);
            add(t, b + 1, -value);
        }

        // point query
        static int get1(int[] t, int i) {
            return sum(t, i);
        }

        public HeavyLightDecomposition(List<Integer>[] tree) {
            this.tree = tree;
            int n = tree.length;

            size = new int[n];
            parent = new int[n];
            tin = new int[n];
            tout = new int[n];
            calcSizeParentTinTout(0);

            path = new int[n];
            pathSize = new int[n];
            pathPos = new int[n];
            pathRoot = new int[n];
            firstPath = new int[n];
            lastPath = new int[n];
            buildPaths(0);

            value = new int[pathCount][];
            delta = new int[pathCount][];
            t = new int[n];

            for (int i = 0; i < pathCount; i++) {
                int m = pathSize[i];

                value[i] = new int[2 * m];
                for (int j = 0; j < m; j++)
                    value[i][j + m] = getInitValue();
                for (int j = 2 * m - 1; j > 1; j -= 2)
                    value[i][j >> 1] = queryOperation(value[i][j], value[i][j ^ 1]);

                delta[i] = new int[2 * m];
                Arrays.fill(delta[i], getNeutralDelta());
            }
        }

        void calcSizeParentTinTout(int root) {
            int n = tree.length;
            int[] curEdge = new int[n];
            int[] stack = new int[n];
            stack[0] = root;
            parent[root] = -1;
            for (int top = 0; top >= 0; ) {
                int u = stack[top];
                if (curEdge[u] == 0) {
                    tin[u] = time++;
                    size[u] = 1;
                }
                if (curEdge[u] < tree[u].size()) {
                    int v = tree[u].get(curEdge[u]++);
                    if (curEdge[v] == 0) {
                        stack[++top] = v;
                        parent[v] = u;
                    }
                } else {
                    --top;
                    if (parent[u] != -1)
                        size[parent[u]] += size[u];
                    tout[u] = time++;
                }
            }
        }

        int newPath(int u) {
            pathRoot[pathCount] = u;
            return pathCount++;
        }

        void buildPaths(int root) {
            int n = tree.length;
            int[] curEdge = new int[n];
            int[] stackPath = new int[n];
            int[] stack = new int[n];
            stack[0] = root;
            stackPath[0] = newPath(root);
            for (int top = 0; top >= 0; ) {
                int u = stack[top];
                int path = stackPath[top];
                if (curEdge[u] == 0) {
                    firstPath[u] = pathCount;
                    this.path[u] = path;
                    pathPos[u] = pathSize[path]++;
                }
                if (curEdge[u] < tree[u].size()) {
                    int v = tree[u].get(curEdge[u]++);
                    if (curEdge[v] == 0) {
                        stack[++top] = v;
                        stackPath[top] = 2 * size[v] >= size[u] ? path : newPath(v);
                    }
                } else {
                    lastPath[u] = pathCount - 1;
                    --top;
                }
            }
        }

        void pushDelta(int path, int i) {
            int d = 0;
            for (; (i >> d) > 0; d++)
                ;
            for (d -= 2; d >= 0; d--) {
                int x = i >> d;
                value[path][x >> 1] = joinValueWithDelta0(path, x >> 1);
                delta[path][x] = joinDeltas(delta[path][x], delta[path][x >> 1]);
                delta[path][x ^ 1] = joinDeltas(delta[path][x ^ 1], delta[path][x >> 1]);
                delta[path][x >> 1] = getNeutralDelta();
            }
        }

        int joinValueWithDelta0(int path, int i) {
            return joinValueWithDelta(value[path][i], delta[path][i]);
        }

        int queryPath(int path, int from, int to) {
            modifyPath(path, 0, pathSize[path] - 1, get1(t, path));
            add(t, path, path, -get1(t, path));

            from += value[path].length >> 1;
            to += value[path].length >> 1;
            pushDelta(path, from);
            pushDelta(path, to);
            int res = getNeutralValue();
            for (; from <= to; from = (from + 1) >> 1, to = (to - 1) >> 1) {
                if ((from & 1) != 0)
                    res = queryOperation(res, joinValueWithDelta0(path, from));
                if ((to & 1) == 0)
                    res = queryOperation(res, joinValueWithDelta0(path, to));
            }
            return res;
        }

        void modifyPath(int path, int from, int to, int delta) {
            from += value[path].length >> 1;
            to += value[path].length >> 1;
            pushDelta(path, from);
            pushDelta(path, to);
            int ta = -1;
            int tb = -1;
            for (; from <= to; from = (from + 1) >> 1, to = (to - 1) >> 1) {
                if ((from & 1) != 0) {
                    this.delta[path][from] = joinDeltas(this.delta[path][from], delta);
                    if (ta == -1)
                        ta = from;
                }
                if ((to & 1) == 0) {
                    this.delta[path][to] = joinDeltas(this.delta[path][to], delta);
                    if (tb == -1)
                        tb = to;
                }
            }
            for (int i = ta; i > 1; i >>= 1)
                value[path][i >> 1] = queryOperation(joinValueWithDelta0(path, i), joinValueWithDelta0(path, i ^ 1));
            for (int i = tb; i > 1; i >>= 1)
                value[path][i >> 1] = queryOperation(joinValueWithDelta0(path, i), joinValueWithDelta0(path, i ^ 1));
        }

        boolean isAncestor(int p, int ch) {
            return tin[p] <= tin[ch] && tout[ch] <= tout[p];
        }

        public int query(int a, int b) {
            int res = getNeutralValue();
            for (int root; !isAncestor(root = pathRoot[path[a]], b); a = parent[root])
                res = queryOperation(res, queryPath(path[a], 0, pathPos[a]));
            for (int root; !isAncestor(root = pathRoot[path[b]], a); b = parent[root])
                res = queryOperation(res, queryPath(path[b], 0, pathPos[b]));
            return queryOperation(res,
                    queryPath(path[a], Math.min(pathPos[a], pathPos[b]), Math.max(pathPos[a], pathPos[b])));
        }

        public void addSubTree(int u, int value) {
            add(t, firstPath[u], lastPath[u], value);
            modifyPath(path[u], pathPos[u], pathSize[path[u]] - 1, value);
        }
    }
}

class InputReader {
    final InputStream is;
    final byte[] buf = new byte[1024];
    int pos;
    int size;

    public InputReader(InputStream is) {
        this.is = is;
    }

    public int nextInt() {
        int c = read();
        while (isWhitespace(c))
            c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = read();
        } while (!isWhitespace(c));
        return res * sign;
    }

    public String next() {
        int c = read();
        while (isWhitespace(c))
            c = read();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
            c = read();
        } while (!isWhitespace(c));
        return sb.toString();
    }

    int read() {
        if (size == -1)
            throw new InputMismatchException();
        if (pos >= size) {
            pos = 0;
            try {
                size = is.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (size <= 0)
                return -1;
        }
        return buf[pos++] & 255;
    }

    static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

}