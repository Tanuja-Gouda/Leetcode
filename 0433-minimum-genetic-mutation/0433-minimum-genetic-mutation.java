class Solution {

    public int minMutation(String startGene,
                           String endGene,
                           String[] bank) {

        Set<String> bankSet =
                new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(startGene);

        char[] genes = {'A', 'C', 'G', 'T'};

        int mutations = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(endGene)) {
                    return mutations;
                }

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char gene : genes) {

                        arr[j] = gene;

                        String next =
                                new String(arr);

                        if (bankSet.contains(next)) {

                            q.offer(next);
                            bankSet.remove(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            mutations++;
        }

        return -1;
    }
}