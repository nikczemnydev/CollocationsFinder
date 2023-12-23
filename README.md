Java - CollocationsFinder: This project is a tool for finding collocations in a given text. Collocations are words that co-occur more frequently than expected by chance. You can train this program on any text (I like to use “Moby Dick” as an example, which you can download here (https://www.gutenberg.org/ebooks/2701 - I suggest the plain utf-8 text version), and then it will tell you if any two words you want to check are collocations. For this simple implementation, I used the criterion that a word pair is a collocation if its probability is higher than the product of the individual probabilities.

Please note that training the program on very large texts (with hundreds of millions or billions of words) can take a while. For a ~500,000 words novel, it takes about 900-950 milliseconds (less than 1 second) on a mid-range modern pc with a very fast ssd nvme drive.

# INSTRUCTIONS FOR WINDOWS #
1. Download and install JDK. (link: https://www.oracle.com/java/technologies/downloads/#jdk21-windows)
2. Download CollocationsFinder.java from the /src folder.
3. Download any book you like from Project Gutenberg website. TXT format recommended. (link: https://www.gutenberg.org/)
4. Rename your book file to book.txt and put it directly in your C:\\ directory. (I will eventually make version that takes the directory as command-line argument, right now it's hardcoded cause it's easier to test.)
5. Open CMD and navigate to wherever you put CollocationsFinder.java file.
6. Compile the program using "javac CollocationsFinder.java" command.
7. Run it using "java CollocationsFinder" command.

![image](https://github.com/nikczemnydev/CollocationsFinder/assets/136376818/a99ad779-e90d-4c3b-b260-38ec43eec31f)

