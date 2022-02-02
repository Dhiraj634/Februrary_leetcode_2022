public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for(int price : prices){
            ans = Math.max(ans, price-min);
            min = Math.min(min,price);
        }
        return ans;
    }
}
