class Leaderboard {

    private HashMap<Integer, Integer> scores;

    public Leaderboard() {

        this.scores = new HashMap<Integer, Integer>();

    }

    public void addScore(int playerId, int score) {

        if(!this.scores.containsKey(playerId)){
            this.scores.put(playerId, 0);
        }

        this.scores.put(playerId, this.scores.get(playerId) + score);
    }

    public int top(int K) {

        PriorityQueue <Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());

        for(Map.Entry<Integer, Integer> entry : this.scores.entrySet()){
            heap.offer(entry);
            if(heap.size() > K){
                heap.poll();
            }
        }

        int total = 0;
        while(!heap.isEmpty()){
            total += heap.poll().getValue();
        }
        return total;
    }

    public void reset(int playerId) {
        this.scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */