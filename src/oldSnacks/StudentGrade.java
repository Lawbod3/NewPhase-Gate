package oldSnacks;

import java.util.*;


public class StudentGrade {

    public static void main(String...args) {

        Scanner collector = new Scanner(System.in);


        System.out.println("How many students do you have?");
        int student = collector.nextInt();
        while(student <= 0){
            System.out.println("Invalid input, please input the correct details");
            student = collector.nextInt();
        }

        System.out.println("How many subject do they offer?");
        int subject = collector.nextInt();
        while(subject <= 0){
            System.out.println("Invalid input, please input the correct details");
            subject = collector.nextInt();

        }


        System.out.println("""
Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Saved succesfully
""");


        int[][] score = new int[student][subject];
        String[] name = new String[student];

        for(int row = 0; row < score.length; row++){
            System.out.printf("%nEnter student%d name: ", row + 1);
            collector.nextLine();
            String studentName =  collector.nextLine();
            name[row] = studentName;


            for(int column = 0; column < score[row].length; column++) {
                System.out.printf("Enter score for subject%d: ", column + 1);
                score[row][column] = collector.nextInt();

                while(score[row][column] < 0 || score[row][column] >= 101) {
                    System.out.println("Invalid input, please input the correct details");
                    score[row][column] = collector.nextInt();

                }

            }

        }


        System.out.println("""
Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Saved succesfully
""");

        double[] totalScore = new double[student];
        double[] averageScore = new double[student];
        double[] subjectTotal = new double[subject];
        double[] subjectAverage = new double[subject];
        double classTotal = 0;
        double classAverage = 0;
        int grandcount = subject * student;

        for(int row = 0; row < student; row++) {
            double total = 0;

            for(int column = 0; column < subject; column++) {
                total += score[row][column];
                classTotal += score[row][column];
            }

            totalScore[row] = total;
            averageScore[row] = total / (int)subject;
        }

        for(int column = 0; column < subject; column++) {
            double totalSubject = 0;

            for(int row = 0; row < student; row++) {
                totalSubject += score[row][column];
            }

            subjectTotal[column] = totalSubject;
            subjectAverage[column] = totalSubject / (int)student;
        }
        classAverage = classTotal / student;

        double hardestSubject = 100 * subject;
        double easiestSubject = 0;
        int hardSubCount = 0;
        int easySubCount = 0;
        for(int column = 0; column < subject; column++) {
            if(subjectTotal[column] < hardestSubject)hardestSubject = subjectTotal[column];

        }

        for(int column = 0; column < subject; column++) {
            if(subjectTotal[column] == hardestSubject){
                hardSubCount++;
                break;
            }

            hardSubCount = hardSubCount + 1;

        }

        for(int column = 0; column < subject; column++) {
            if(subjectTotal[column] > easiestSubject)easiestSubject = subjectTotal[column];

        }

        for(int column = 0; column < subject; column++) {
            if(subjectTotal[column] == easiestSubject){
                easySubCount++;
                break;
            }

            easySubCount = easySubCount + 1;

        }
        int i = 0;
        int min = 100;
        int max = 0;
        int[] numberOfPass = new int[subject];
        int pass = 0;
        int fail = 0;
        int[] numberOfFail = new int[subject];
        int[] highestPerSub = new int[subject];
        int[]  highestPerSubCount = new int[subject];
        int[] lowestPerSub = new int[subject];
        int[]  lowestPerSubCount = new int[subject];

        while(i < subject){
            for(int row = 0; row < student; row++) {
                if(score[row][i] > max){
                    max = score[row][i];
                }

                if(score[row][i] < min){
                    min = score[row][i];
                }

                if(score[row][i] > 40)pass++;
                else fail++;
            }

            for(int row = 0; row < student; row++) {
                if(score[row][i] == max){
                    highestPerSubCount[i] = row + 1;
                }

                if(score[row][i] == min){
                    lowestPerSubCount[i] = row + 1;
                }
            }

            numberOfPass[i] = pass;
            numberOfFail[i] = fail;
            highestPerSub[i] = max;
            lowestPerSub[i] = min;

            pass = 0;
            fail = 0;
            max = 0;
            min = 100;

            i++;
        }

        int overallHighestScoreStudent = 0;
        int subjectHighestScore = 0;
        int overallLowestScoreStudent = 0;
        int subjectLowestScore = 0;
        int highest = 0;
        int lowest = 100;

        for(int row = 0; row < student; row++){
            for(int column = 0; column < subject; column++){

                if(score[row][column] > highest){
                    highest = score[row][column];}

                if(score[row][column] < lowest){
                    lowest = score[row][column];}
            }
        }

        for(int row = 0; row < student; row++){
            for(int column = 0; column < subject; column++){

                if(score[row][column] == highest){
                    overallHighestScoreStudent = row + 1;
                    subjectHighestScore = column + 1;   }

                if(score[row][column] == lowest){
                    overallLowestScoreStudent = row + 1;
                    subjectLowestScore = column + 1; }

            }
        }


        double maximum = Double.MIN_VALUE;
        double minimum = Double.MAX_VALUE;
        int bestStudent = 0;
        int worstStudent = 0;

        for(int count = 0; count < student; count++){

            if(totalScore[count] > maximum){
                maximum = totalScore[count]; }

            if(totalScore[count] < minimum){
                minimum = totalScore[count]; }

        }

        for(int count = 0; count < student; count++){

            if(totalScore[count] == maximum){
                bestStudent  = count + 1; }

            if(totalScore[count] == minimum){
                worstStudent  = count + 1; }


        }









        int[] position = new int[student];

        for(int outer = 0; outer < student; outer++){
            int record = 1;
            for(int inner = 0; inner < student; inner++){

                if(totalScore[outer] < totalScore[inner])record++;


            }

            position[outer] = record;

        }


        String[] subOutput =  new String[subject];
        Arrays.fill(subOutput, "sub");

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------\n");
        System.out.print("STUDENT      sub1");
        for(int row = 1; row < subject; row++){
            System.out.printf("%5s%d", subOutput[row], row + 1);
        }
        System.out.printf("%5s%8s%8s\n", "TOT", "AVE", "POS");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------\n");






        for(int row = 0; row < student; row++){
            System.out.printf("Student %d    ", row + 1);
            for(int column = 0; column < subject; column++){


                System.out.printf("%5d",  score[row][column]);

            }
            System.out.printf("%8.2f%8.2f%5d", totalScore[row], averageScore[row], position[row]);

            System.out.println();
        }


        for(int count = 0; count < subject; count++){

            System.out.printf("""

Subject %d
Highest scoring student is: student %d scoring %d
Lowest scoring student is: student %d scoring %d
Total score is: %.2f 
Average score is: %.2f
number of passes is: %d
nmber of fail is: %d

""", count + 1, highestPerSubCount[count], highestPerSub[count], lowestPerSubCount[count], lowestPerSub[count], subjectTotal[count], subjectAverage[count], numberOfPass[count], numberOfFail[count]);


        }



        System.out.printf("""

The hardest subject is Subject %d with %d failures
The easiest subject is Subject %d with %d passes
The overall Highest score is scored by Student %d in Subject %d scoring %d 
The overall Lowest score is scored by Student %d in Subject %d scoring %d
----------------------------------------------------------------------------
----------------------------------------------------------------------------


""", hardSubCount, numberOfFail[hardSubCount - 1], easySubCount, numberOfPass[easySubCount- 1], overallHighestScoreStudent, subjectHighestScore, highest, overallLowestScoreStudent, subjectLowestScore, lowest);


        System.out.printf("""
----------------------------------------------------------------------------
----------------------------------------------------------------------------


Best Graduating student is: Student %d scoring %.2f


----------------------------------------------------------------------------
----------------------------------------------------------------------------

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

Worst Graduating student is: Student %d scoring %.2f 


!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


-----------------------------------------------------------------------------
-----------------------------------------------------------------------------

Class Total is: %.2f 

Class Average is: %.2f 

-----------------------------------------------------------------------------
----------------------------------------------------------------------------- 

""", bestStudent, maximum, worstStudent, minimum, classTotal, classAverage);





    }

}
