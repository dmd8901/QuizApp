package com.example.android.quizapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitar Dimitrov on 22/03/2017.
 */

public class QuestionsFeeder {
    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        //Question 1
        List<String> answers = generateAnswers("Oxford", "Birmingham", "Dublin", "London");
        Question question = new Question("What is the capital of The United Kingdom ? ", answers, 4);
        questions.add(question);


        //Question 2
        answers = generateAnswers("Kigali", "Doha", "Dakar", "Apia");
        question = new Question("What is the capital of Senegal ? ", answers, 3);
        questions.add(question);

        //Question 3
        answers = generateAnswers("Belgrade", "Bratislava", "Zagreb", "Warsaw");
        question = new Question("What is the capital of Serbia ? ", answers, 1);
        questions.add(question);

        //Question 4
        answers = generateAnswers("Dodoma", "Lomé", "Tunis", "Bern");
        question = new Question("What is the capital of Togo ? ", answers, 2);
        questions.add(question);

        //Question 5
        answers = generateAnswers("Hanoi", "Lusaka", "Manila", "Harare");
        question = new Question("What is the capital of Vietnam ? ", answers, 1);
        questions.add(question);

        //Question 6
        answers = generateAnswers("Moscow", "Victoria", "Riga", "Stockholm");
        question = new Question("What is the capital of Sweden ? ", answers, 4);
        questions.add(question);

        //Question 7
        answers = generateAnswers("Reykjavik", "Conakry", "Bissau", "Tehran");
        question = new Question("What is the capital of Guinea-Bissau ? ", answers, 3);
        questions.add(question);

        //Question 8
        answers = generateAnswers("Asmara", "Santiago", "Moroni", "Brazzaville");
        question = new Question("What is the capital of Eritrea ? ", answers, 1);
        questions.add(question);

        //Question 9
        answers = generateAnswers("Macau", "Beijing", "Shanghai", "Shenzhen");
        question = new Question("What is the capital of China ? ", answers, 2);
        questions.add(question);

        //Question 10
        answers = generateAnswers("Chile", "Rio", "Brasilia", "Lima");
        question = new Question("What is the capital of Brazil ? ", answers, 3);
        questions.add(question);

        //Question 11
        answers = generateAnswers("Yaounde", "Gaborone", "Thimphu", "Minsk");
        question = new Question("What is the capital of Cameroon ? ", answers, 1);
        questions.add(question);

        //Question 12
        answers = generateAnswers("Ohrid", "Sofia", "Dobrich", "Varna");
        question = new Question("What is the capital of Bulgaria ? ", answers, 2);
        questions.add(question);

        //Question 13
        answers = generateAnswers("Seoul", "Dili", "Dublin", "Dodoma");
        question = new Question("What is the capital of Tanzania ? ", answers, 4);
        questions.add(question);

        //Question 14
        answers = generateAnswers("Luanda", "Vienna", "Belmopan", "Praia");
        question = new Question("What is the capital of Belize ? ", answers, 3);
        questions.add(question);

        //Question 15
        answers = generateAnswers("Buenos Aires", "Luanda", "Yerevan", "Baku");
        question = new Question("What is the capital of Argentina ? ", answers, 1);
        questions.add(question);

        //Question 16
        answers = generateAnswers("Mbabane", "Kyiv", "Kampala", "Port Vila");
        question = new Question("What is the capital of Uganda ? ", answers, 3);
        questions.add(question);

        //Question 17
        answers = generateAnswers("Manama", "Canberra", "Belmopan", "Thimphu");
        question = new Question("What is the capital of Australia ? ", answers, 2);
        questions.add(question);

        //Question 18
        answers = generateAnswers("Athens", "Tegucigalpa", "Budapest", "Jakarta");
        question = new Question("What is the capital of Greece? ", answers, 1);
        questions.add(question);

        //Question 19
        answers = generateAnswers("Riga", "Nairobi", "Astana", "Tokyo");
        question = new Question("What is the capital of Japan ? ", answers, 4);
        questions.add(question);

        //Question 20
        answers = generateAnswers("Monaco", "Palikir", "Kuala Lumpur", "Majuro");
        question = new Question("What is the capital of Malaysia ? ", answers, 3);
        questions.add(question);

        //Question 21
        answers = generateAnswers("Windhoek", "Monaco", "Ulaanbaatar", "Maputo");
        question = new Question("What is the capital of Monaco ? ", answers, 2);
        questions.add(question);

        //Question 22
        answers = generateAnswers("Kigali", "Doha", "Ngerulmud", "Manila");
        question = new Question("What is the capital of Palau ? ", answers, 3);
        questions.add(question);

        //Question 23
        answers = generateAnswers("Singapore", "Honiara", "Victoria", "São Tomé");
        question = new Question("What is the capital of Singapore ? ", answers, 1);
        questions.add(question);

        //Question 24
        answers = generateAnswers("Sana'a", "Lusaka", "Caracas", "Harare");
        question = new Question("What is the capital of Venezuela ? ", answers, 3);
        questions.add(question);

        //Question 25
        answers = generateAnswers("Astana", "Berlin", "Oslo", "Bern");
        question = new Question("What is the capital of Switzerland ? ", answers, 4);
        questions.add(question);





        return questions;
    }
    /*
    Question List

     */

    public List<String> generateAnswers(String ans1, String ans2, String ans3, String ans4){
        List<String> answers = new ArrayList<>();
        answers.add(ans1);
        answers.add(ans2);
        answers.add(ans3);
        answers.add(ans4);
        return answers;
    }
}
