# Riddle - Quiz app
Google Jam Project

View design mocs for the app at https://github.com/imariamj/riddle/wiki/Riddle-Mockups

Riddle is a simple quiz app that allows a user to choose from a list of categories to play quiz for.

The features include:
- List of quiz categories 
- Set of questions for the respective categories along with multiple choices of answers
- Score at the end of quiz
- Selected and correct answers at the end of the quiz

# What you will find in Riddle:
1. Main view that displays a list of quiz categories that a user can choose from
2. Quiz start activity which is launcher view for a quiz category
3. Question activity: Displayes questions one at a time along with answer choices implemented in a radio group,
user can press "Next" button to get the next question, the data changes dynamically in the same activity. 
Once answered user can not navigate back to the previous question.
On pressing device back button, an alert asking the user to either quit the quiz or continue is given.
4. On completion of all questions, a Score Activity telling the points scored by user and info on correct answers for the questions is given. 

# Getting Started
Clone the repository

Start with cloning the project to your local machine:

https://github.com/imariamj/riddle.git

For Android Studio with Gradle
- Open Android Studio
- Select open an Existing Android studio project and select the Riddle folder
- Open Gradle from the right side menu , select :app , tap on Run to build the apk

After building & running the project. If an actual physical device is connected then you should be able to see Riddle app open up on the device.
If there isn't any device connected then android studio will launch an Emulator and will run the project in the same.

