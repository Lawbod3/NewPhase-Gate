package oldSnacks;

import java.util.*;

public class Mbit {
    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);


        String[] questions = {
                " ",
                "QUESTION 1: expand energy, enjoy groups conserve energy (A) or enjoy one-on-one (B)",
                "QUESTION 2: interpret literally (A) or look for meaning and possibilities (B)",
                "QUESTION 3: logical, thinking (A) or questioning, empathetic, feeling, accommodating (B)",
                "QUESTION 4: organized, orderly (A) or flexible,adaptable (B)",
                "QUESTION 5: more outgoing, think out loud (A) or  more reserved, think to yourself (B)",
                "QUESTION 6: practical,realistic, experiential (A)  imaginative, innovative, or theoretical (B)",
                "QUESTION 7: Candid, straight forward,  frank (A) or tactful, kind, encouraging (B)",
                "QUESTION 8: Plan,schedule (A) or unplanned, or spontaneous (B)",
                "QUESTION 9: Seek many tasks, public activities, interaction with others (A) or seek private, solitary activities with quiet to concentrate (B)",
                "QUESTION 10: Standard, usual, conventional (A) or different,novel,unique (B)",
                "QUESTION 11: Firm, tend to criticize, hold the line (A) or gentle, tend to appreciate, conciliate (B)",
                "QUESTION 12: Regulated,structured (A) or easygoing, live and let live (B)",
                "QUESTION 13: External,communicative, express yourself (A) or internal, reticent, keep to yourself (B)",
                "QUESTION 14: Focus on here-and-now (A) or look to the future,global perspective, bigpicture (B)",
                "QUESTION 15: Tough-minded,just (A) or tender-hearted, merciful (B)",
                "QUESTION 16: Preparation, plan ahead (A) or go with the flow, adapt as you go (B)",
                "QUESTION 17: Active,initiate (A) or reflective, deliberate (B)",
                "QUESTION 18: Facts, things, what is (A) or ideas, dreams, what could be, philosophical (B)",
                "QUESTION 19:Matter of fact,issue-oriented (A) or sensitive, people-oriented, compassionate (B)",
                "QUESTION 20: Control,govern (A) or latitude,freedom (B)"

        };


        char[] array = new char[21];

        char answer = ' ';
        int answerA = 0;
        int answerB = 0;
        int introvert = 0;
        int extrovert = 0;
        int sensing = 0;
        int intuitive = 0;
        int thinking = 0;
        int feeling = 0;
        int judging = 0;
        int perceptive = 0;

        while(answer != 'Z'){
            System.out.println("Personality trait Test, endeavor you answer the questions honestly. To end the test at any point enter letter Z ");

            System.out.println("Please enter your name: ");
            String name = keyboard.nextLine();

            if(name.equalsIgnoreCase("Z")) break;


            for (int i = 1; i <= 20; i++){
                System.out.println(questions[i]);


                System.out.println("Enter A or B : ");
                answer = keyboard.nextLine().toUpperCase().charAt(0);
                array[i] = answer;

                if(answer == 'Z') break;
                if(answer != 'A' && answer != 'B'){
                    System.out.println("please input letter A or B to continue");
                    i--;
                    continue;
                }

                if(i == 1 || i == 5 || i == 9 || i == 13 || i == 17){
                    if(answer == 'A'){
                        extrovert++;
                        answerA++;
                    }
                    else{ introvert++;
                        answerB++;
                    }

                }

                if(i == 2 || i == 6 || i == 10 || i == 14 || i == 18){
                    if(answer == 'A'){
                        sensing++;
                        answerA++;
                    }
                    else{ intuitive++;
                        answerB++;
                    }

                }

                if(i == 3 || i == 7 || i == 11 || i == 15 || i == 19){
                    if(answer == 'A'){
                        thinking++;
                        answerA++;
                    }
                    else{  feeling++;
                        answerB++;
                    }

                }

                if(i == 4 || i == 8 || i == 12 || i == 16 || i == 20){
                    if(answer == 'A'){
                        judging++;
                        answerA++;
                    }
                    else{  perceptive++;
                        answerB++;
                    }

                }





            }



            String trait = "";

            if (extrovert > introvert){
                trait += "E";
            }
            else { trait += "I";  }

            if (sensing > intuitive) trait += "S";
            else { trait += "N";  }

            if (thinking > feeling) trait += "T";
            else { trait += "F";  }

            if (judging > perceptive) trait += "J";
            else { trait += "P";  }

            Traits mbit = Traits.valueOf(trait);

            System.out.printf("Your personality trait is %s%nYou are %s",  mbit, mbit.getDetails());
            System.out.println();
        }


    }

}
