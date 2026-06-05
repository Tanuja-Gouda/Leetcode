class Solution {

    public int openLock(String[] deadends,
                        String target) {

        Set<String> dead =
                new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(target)) {
                    return moves;
                }

                for (String next : neighbors(curr)) {

                    if (!dead.contains(next) &&
                        !visited.contains(next)) {

                        visited.add(next);
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private List<String> neighbors(String lock) {

        List<String> result = new ArrayList<>();

        char[] arr = lock.toCharArray();

        for (int i = 0; i < 4; i++) {

            char original = arr[i];

            arr[i] = original == '9'
                    ? '0'
                    : (char)(original + 1);

            result.add(new String(arr));

            arr[i] = original == '0'
                    ? '9'
                    : (char)(original - 1);

            result.add(new String(arr));

            arr[i] = original;
        }

        return result;
    }
}