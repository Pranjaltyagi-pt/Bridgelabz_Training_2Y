package Assignment;

public class CircularTour {

        static int findStartingPoint(int[] petrol, int[] distance) {

            int n = petrol.length;

            int start = 0;
            int balance = 0;
            int total = 0;

            for (int i = 0; i < n; i++) {

                int surplus = petrol[i] - distance[i];

                balance += surplus;
                total += surplus;

                if (balance < 0) {

                    start = i + 1;
                    balance = 0;
                }
            }

            if (total < 0) {
                return -1;
            }

            return start;
        }

        public static void main(String[] args) {

            int[] petrol = {4, 6, 7, 4};
            int[] distance = {6, 5, 3, 5};

            int result = findStartingPoint(petrol, distance);

            System.out.println("Starting Point: " + result);
        }
    }
