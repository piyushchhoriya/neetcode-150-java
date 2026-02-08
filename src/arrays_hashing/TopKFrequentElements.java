class Solution {
    class Obj{
        int num;
        int freq;
        public Obj(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length ==0){
            return new int[]{};
        }
        HashMap<Integer,Integer> frequencyCount = new HashMap<>();
        for(int num :  nums){
            frequencyCount.put(num,frequencyCount.getOrDefault(num,0)+1);
        }
        PriorityQueue<Obj> minHeap = new PriorityQueue<>((a,b) -> a.freq-b.freq);
        for(Map.Entry<Integer,Integer> entry : frequencyCount.entrySet()){
            minHeap.offer(new Obj(entry.getKey(),entry.getValue()));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            Obj ob = minHeap.poll();
            arr[i]=ob.num;
        }
        return arr;
    }
}