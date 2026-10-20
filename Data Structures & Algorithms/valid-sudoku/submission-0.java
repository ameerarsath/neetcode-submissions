
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> check = new HashSet<>();
        HashSet<Character> checkcol = new HashSet<>();
        List<List<Character>> arr = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // row
                if (board[i][j] != '.') {
                    if (check.contains(board[i][j])) {
                        System.out.println("row");
                        return false;
                    }
                    check.add(board[i][j]);
                }

                // col
                if (board[j][i] != '.') {
                    if (checkcol.contains(board[j][i])) {
                        System.out.println(board[j][i] + " col");
                        return false;
                    }
                    checkcol.add(board[j][i]);
                }

                // 3x3 box
                if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                    int si = i - 2, sj = j - 2;
                    arr.clear();

                    for (int r = si; r <= i; r++) {
                        for (int c = sj; c <= j; c++) {
                            if (board[r][c] == '.') {
                                continue;
                            }

                            if (arr.size() == 0) {
                                arr.add(new ArrayList<>());
                            }

                            if (arr.get(0).contains(board[r][c])) {
                                System.out.println(board[r][c] + " box");
                                return false;
                            }

                            arr.get(0).add(board[r][c]);
                        }
                    }
                }
            }

            check.clear();
            checkcol.clear();
        }

        return true;
    }
}
