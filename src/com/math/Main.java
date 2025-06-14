package com.math;

import java.math.*;

public class Main {
    /** 常用的数学方法 */

    // 1.求最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 2.求最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 3.求平方根
    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    // 4.求立方根
    public static double cbrt(double a) {
        return Math.cbrt(a);
    }

    // 5.求绝对值
    public static int abs(int a) {
        return Math.abs(a);
    }

    // 8.求幂
    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    // 9.求对数
    public static double log(double a) {
        return Math.log(a);
    }

    // 10.判断质数
    // 质数是指只能被1和它本身整除的自然数
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false; // 0和1不是质数
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // 11.素数筛法 素数与质数是同义词，都是指只能被1和它本身整除的自然数。
    // 质数筛法是一种高效的算法，用于找出一定范围内的所有素数。
    // 该算法的基本思想是：从2开始，依次将每个数的倍数标记为非素数，直到n的平方根为止。
    // 这样，所有未被标记的数就是素数。
    // 该算法的时间复杂度为O(nloglogn)，空间复杂度为O(n)。
    // 该算法的实现步骤如下：
    // 1.创建一个布尔数组isPrime，长度为n+1，初始值为true。
    // 2.将isPrime[0]和isPrime[1]设为false，表示0和1不是素数。
    // 3.从2开始，依次遍历到n的平方根。
    // 4.如果isPrime[i]为true，则将i的倍数标记为false。
    // 5.返回isPrime数组。
    // 时间复杂度O(nloglogn)，空间复杂度O(n)
    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {  //如果i是素数
                //将i的倍数标记为非素数
                for (int j = i * i; j <= n; j += i) {  //为什么从i*i开始？因为i*i之前的数已经被标记为非素数了 
                    //比如n=100,i=2时会从4开始标记，
                    //把2的倍数，如2,4,6,8,10,12...都标记为非素数
                    //因为i的倍数小于i*i的数已经被标记为非素数了 
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    //12.分解质因数
    // 分解质因数是指将一个整数分解为若干个质数的乘积。
    // 例如，12可以分解为2*2*3。
    // 分解质因数的算法是：
    // 1.从2开始，依次遍历到n的平方根。
    // 2.如果n能被i整除，则将i加入结果列表，并将n除以i。
    // 3.如果n不能被i整除，则继续遍历下一个i。
    // 4.如果n大于1，则将n加入结果列表。
    // 5.返回结果列表。
    // 6.时间复杂度O(nlogn)，空间复杂度O(n)
    //举个例：
    // 1.输入：n=12
    // 2.输出：[2, 2, 3]
    // 3.解释：12=2*2*3
    // 4.过程：
    // 1.从2开始，12能被2整除，将2加入结果列表，n=12/2=6
    // 2.6能被2整除，将2加入结果列表，n=6/2=3
    // 3.3不能被2整除，继续遍历下一个i=3
    // 4.3能被3整除，将3加入结果列表，n=3/3=1
    // 5.3大于1，将3加入结果列表，n=1
    // 6.返回结果列表[2, 2, 3]
    public static int[] primeFactorization(int n) {
        int[] factors = new int[n]; // 用于存储质因数的数组
        int index = 0; // 质因数的索引
        for (int i = 2; i*i<=n; i++) { 
            while (n % i == 0) { // 如果n能被i整除
                factors[index++] = i; // 将i加入结果列表
                n /= i; // 将n除以i
            }
        }
        if (n > 1) { // 如果n大于1，则将n加入结果列表
            factors[index++] = n;
        }
        int[] result = new int[index]; // 创建结果数组
        for (int i = 0; i < index; i++) { // 将质因数复制到结果数组
            result[i] = factors[i];
        }
        return result; // 返回结果列表
    }

    // 13.求组合数C(n,k)
    // 组合数是指从n个不同的元素中，任意取出k个元素的组合数。
    // 组合数的计算公式为：C(n,k) = n! / (k! * (n-k)!)。
    // 其中n!表示n的阶乘，k!表示k的阶乘，(n-k)!表示(n-k)的阶乘。
    // 组合数的性质：
    // C(n,k) = C(n-1,k-1) + C(n-1,k)


    // 2.动态规划的方法的实现步骤如下：
    // 1.创建一个二维数组dp，长度为n+1，宽度为k+1，初始值为0。
    // 2.将dp[0][0]设为1，表示C(0,0) = 1。
    // 3.从1到n，依次遍历i。
    // 4.从1到k，依次遍历j。
    // 5.如果j > i，则dp[i][j] = 0。
    // 6.如果j <= i，则dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。
    // 7.返回dp[n][k]。
    public static int C(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, k); j++) {  // 这里的Math.min(i, k)是为了避免数组越界
                // 如果j > i，则dp[i][j] = 0
                // 如果j <= i，则dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
                // 这里的dp[i-1][j-1]表示从前i-1个元素中选j-1个元素，dp[i-1][j]表示从前i-1个元素中选j个元素
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }
    
    //14.求全排列
    //如何简单的求一个数的全排列呢？
    // 1.使用递归的方法来实现全排列
    // 递归+循环的方式来实现全排列
    // 当一个路径走到尽头时，则递归返回，回溯到上一个节点，继续遍历下一个路径。
    // 每一条路径都代表一个全排列。

    
    //实现思路：

    public static void permute(int n) {
        int[] a = new int[n]; // 用于存储全排列的数组
        boolean[] visited = new boolean[n]; // 用于标记是否访问过
        permuteHelper(a, visited, 0); // 调用递归函数   
    }   
    //递归函数
    private static void permuteHelper(int[] a, boolean[] visited, int index) {
        if (index == a.length) { // 如果已经排列完毕
            for (int i = 0; i < a.length; i++) { // 输出全排列
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < a.length; i++) { 
            if (!visited[i]) { // 如果没有访问过
                visited[i] = true; // 标记为已访问
                a[index] = i; // 将当前元素加入全排列
                permuteHelper(a, visited, index + 1); // 递归调用下一个元素
                visited[i] = false; // 回溯，标记为未访问
            }
        }
    }

    
}
