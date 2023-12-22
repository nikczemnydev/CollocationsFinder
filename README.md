Java - CollocationsFinder - in Computational Linguistics collocations are words that appear together much more often than they would only by chance. This program can be trained on any text (I have sort of a tradition to use "Moby Dick" which can be downloaded in full here (https://www.gutenberg.org/ebooks/2701 - I recommend plain utf-8 text version), then based on some factors (like how the training data is related to the words you are looking for) it will tell you if any 2 words you want to search for are collocations. For the sake of this simple implementation I assumed a word pair is a collocation if its probability is greater than the product of the individual probabilities. 

Please not that training the program on very large corpus (in hundreds of millions to billions words large) can take some time, for a ~500.000 words novel it takes approximately 900-950 milliseconds (just under 1 second) on a mid-range modern pc with very fast ssd nvme drive. 

# INSTRUCTIONS FOR WINDOWS #
1. Download and install JDK. (link: https://www.oracle.com/java/technologies/downloads/#jdk21-windows)
2. Download CollocationsFinder.java from the /src folder.
3. Download any book you like from Project Gutenberg website. TXT format recommended. (link: https://www.gutenberg.org/)
4. Rename your book file to book.txt and put it directly in your C:\\ directory. (I will eventually make version that takes the directory as command-line argument, right now it's hardcoded cause it's easier to test.)
5. Open CMD and navigate to wherever you put CollocationsFinder.java file.
6. Compile the program using "javac CollocationsFinder.java" command.
7. Run it using "java CollocationsFinder" command.

![image](https://github.com/nikczemnydev/CollocationsFinder/assets/136376818/a99ad779-e90d-4c3b-b260-38ec43eec31f)

