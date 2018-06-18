package com.company.codelearn;

import android.util.SparseArray;

import java.util.ArrayList;


public class DB {
    private static DB instance = new DB();
    ArrayList<String> lessons = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<QuizElement> quizElements = new ArrayList<>();
    private ArrayList<String> quizAnswers = new ArrayList<>();

    private DB() {
        createLessons();
        createTitles();
        createQuiz();
    }

    public static DB getInstance( ) {
        return instance;
    }

    private void createTitles(){

        titles.add("lessonError");
        titles.add("Lesson 1: Quick C++ History");
        titles.add("Lesson 2: Environment setup");
        titles.add("Lesson 3: Hello World");
        titles.add("Lesson 1: Data types");
        titles.add("Lesson 2: Variables");
        titles.add("Lesson 3: Constants");
        titles.add("Lesson 4: Loops");
        titles.add("Lesson 5: if statement");
        titles.add("Lesson 6: switch");
        titles.add("Lesson 1: Assignment operator");
        titles.add("Lesson 2: Arithmetic operators");
        titles.add("Lesson 3: Increment and decrement");
        titles.add("Lesson 4: Comparision operators");
        titles.add("Lesson 5: Logical operators");
        titles.add("Lesson 6: Conditional Ternary Operator");
        titles.add("Lesson 7: Coma operator");
        titles.add("Lesson 8: Type casting");
        titles.add("Lesson 9: sizeof operator");
        titles.add("Lesson 1: Classes");
        titles.add("Lesson 2: Constructors and descructors");
        titles.add("Lesson 3: Getters and setters");
        titles.add("Lesson 4: The “this” keyword");
        titles.add("Lesson 5: Inheritance");
        titles.add("Lesson 6: Example code");
        titles.add("Lesson 1: Pointer definition");
        titles.add("Lesson 2: Standard pointers");
        titles.add("Lesson 3: Smart pointers");
        titles.add("Lesson 4: Example");
        titles.add("Lesson 1: Polimorphism");
        titles.add("Lesson 2: Encapsulation");
        titles.add("Lesson 3: Abstract classes");
        titles.add("Lesson 1: Multidimensional Arrays");
        titles.add("Lesson 2: References");
        titles.add("Lesson 3: Delete operator");
        titles.add("Lesson 4: Struct");
        titles.add("Lesson 5: Unions");
        titles.add("Lesson 6: Enumerators");
        titles.add("Lesson 1: Macro definitions");
        titles.add("Lesson 2: Conditional Directives");
        titles.add("Lesson 3: Line Directive");
        titles.add("Lesson 4: Error Directive");

    }

    private void createLessons(){

        lessons.add("lessonError");
        lessons.add(history);
        lessons.add(enviroment);
        lessons.add(helloWorld);
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
        lessons.add("placeholder");
    }

    private void createQuiz(){


        quizAnswers.add("1983"); quizAnswers.add("1985"); quizAnswers.add("1981"); quizAnswers.add("1987");
        quizElements.add(new QuizElement(1,"In what year this programming language gained it's name - C++?", new ArrayList<>(quizAnswers),1));
        quizAnswers.clear();

        quizAnswers.add("1990"); quizAnswers.add("1998"); quizAnswers.add("1989"); quizAnswers.add("1985");
        quizElements.add(new QuizElement(1,"In what year C++ was updated to include protected and static members?",new ArrayList<>(quizAnswers),3));
        quizAnswers.clear();

        quizAnswers.add("EDGE C/C++"); quizAnswers.add("GNU C/C++"); quizAnswers.add("Visual C++ (cl)"); quizAnswers.add("Intel C++ Compiler");
        quizElements.add(new QuizElement(1,"Which compiler is most frequently used and  available for free?",new ArrayList<>(quizAnswers),2));
        quizAnswers.clear();

        quizAnswers.add("main()"); quizAnswers.add("f1()"); quizAnswers.add("max()"); quizAnswers.add("create()");
        quizElements.add(new QuizElement(1,"All console programs have one vital function, what is it called?",new ArrayList<>(quizAnswers),1));
        quizAnswers.clear();

        quizAnswers.add("cout<<endl;"); quizAnswers.add("int x = 10;"); quizAnswers.add("return 0;"); quizAnswers.add("#include <iostream>");
        quizElements.add(new QuizElement(1,"Which part of code needs to be added at the beginning for hello world to work ?",new ArrayList<>(quizAnswers),4));
        quizAnswers.clear();


    }


    private String history = "The C++ programming language has a history going back to 1979, when Bjarne Stroustrup was doing work for his Ph.D. thesis. One of the languages Stroustrup had the opportunity to work with was a language called Simula, which as the name implies is a language primarily designed for simulations. The Simula 67 language - which was the variant that Stroustrup worked with - is regarded as the first language to support the object-oriented programming paradigm. Stroustrup found that this paradigm was very useful for software development, however the Simula language was far too slow for practical use.\n" +
            "\n" +
            "Shortly thereafter, he began work on \"C with Classes\", which as the name implies was meant to be a superset of the C language. His goal was to add object-oriented programming into the C language, which was and still is a language well-respected for its portability without sacrificing speed or low-level functionality. His language included classes, basic inheritance, inlining, default function arguments, and strong type checking in addition to all the features of the C language.\n" +
            "\n" +
            "The first C with Classes compiler was called Cfront, which was derived from a C compiler called CPre. It was a program designed to translate C with Classes code to ordinary C. A rather interesting point worth noting is that Cfront was written mostly in C with Classes, making it a self-hosting compiler (a compiler that can compile itself). Cfront would later be abandoned in 1993 after it became difficult to integrate new features into it, namely C++ exceptions. Nonetheless, Cfront made a huge impact on the implementations of future compilers and on the Unix operating system.\n" +
            "\n" +
            "In 1983, the name of the language was changed from C with Classes to C++. The ++ operator in the C language is an operator for incrementing a variable, which gives some insight into how Stroustrup regarded the language. Many new features were added around this time, the most notable of which are virtual functions, function overloading, references with the & symbol, the const keyword, and single-line comments using two forward slashes (which is a feature taken from the language BCPL).\n" +
            "\n" +
            "In 1985, Stroustrup's reference to the language entitled The C++ Programming Language was published. That same year, C++ was implemented as a commercial product. The language was not officially standardized yet, making the book a very important reference. The language was updated again in 1989 to include protected and static members, as well as inheritance from several classes.\n" +
            "\n" +
            "In 1990, The Annotated C++ Reference Manual was released. The same year, Borland's Turbo C++ compiler would be released as a commercial product. Turbo C++ added a plethora of additional libraries which would have a considerable impact on C++'s development. Although Turbo C++'s last stable release was in 2006, the compiler is still widely used.\n" +
            "\n" +
            "In 1998, the C++ standards committee published the first international standard for C++ ISO/IEC 14882:1998, which would be informally known as C++98. The Annotated C++ Reference Manual was said to be a large influence in the development of the standard. The Standard Template Library, which began its conceptual development in 1979, was also included. In 2003, the committee responded to multiple problems that were reported with their 1998 standard, and revised it accordingly. The changed language was dubbed C++03.\n" +
            "\n" +
            "In 2005, the C++ standards committee released a technical report (dubbed TR1) detailing various features they were planning to add to the latest C++ standard. The new standard was informally dubbed C++0x as it was expected to be released sometime before the end of the first decade. Ironically, however, the new standard would not be released until mid-2011. Several technical reports were released up until then, and some compilers began adding experimental support for the new features.\n" +
            "\n" +
            "In mid-2011, the new C++ standard (dubbed C++11) was finished. The Boost library project made a considerable impact on the new standard, and some of the new modules were derived directly from the corresponding Boost libraries. Some of the new features included regular expression support (details on regular expressions may be found here), a comprehensive randomization library, a new C++ time library, atomics support, a standard threading library (which up until 2011 both C and C++ were lacking), a new for loop syntax providing functionality similar to foreach loops in certain other languages, the auto keyword, new container classes, better support for unions and array-initialization lists, and variadic templates.";

    private String enviroment = "Local Environment Setup\n" +
            "If you are still willing to set up your environment for C++, you need to have the following two softwares on your computer.\n" +
            "\n" +
            "Text Editor\n" +
            "This will be used to type your program. Examples of few editors include Windows Notepad, OS Edit command, Brief, Epsilon, EMACS, and vim or vi.\n" +
            "\n" +
            "Name and version of text editor can vary on different operating systems. For example, Notepad will be used on Windows and vim or vi can be used on windows as well as Linux, or UNIX.\n" +
            "\n" +
            "The files you create with your editor are called source files and for C++ they typically are named with the extension .cpp, .cp, or .c.\n" +
            "\n" +
            "A text editor should be in place to start your C++ programming.\n" +
            "\n" +
            "C++ Compiler\n" +
            "This is an actual C++ compiler, which will be used to compile your source code into final executable program.\n" +
            "\n" +
            "Most C++ compilers don't care what extension you give to your source code, but if you don't specify otherwise, many will use .cpp by default.\n" +
            "\n" +
            "Most frequently used and free available compiler is GNU C/C++ compiler, otherwise you can have compilers either from HP or Solaris if you have the respective Operating Systems.\n" +
            "$ g++ -v\n" +
            "Installing GNU C/C++ Compiler\n" +
            "UNIX/Linux Installation\n" +
            "If you are using Linux or UNIX then check whether GCC is installed on your system by entering the following command from the command line −\n" +
            "Using built-in specs.\n" +
            "Target: i386-redhat-linux\n" +
            "Configured with: ../configure --prefix=/usr .......\n" +
            "Thread model: posix\n" +
            "gcc version 4.1.2 20080704 (Red Hat 4.1.2-46)\n" +
            "$ g++ -v\n" +
            "If you have installed GCC, then it should print a message such as the following −\n" +
            "\n" +
            "Using built-in specs.\n" +
            "Target: i386-redhat-linux\n" +
            "Configured with: ../configure --prefix=/usr .......\n" +
            "Thread model: posix\n" +
            "gcc version 4.1.2 20080704 (Red Hat 4.1.2-46)\n" +
            "If GCC is not installed, then you will have to install it yourself using the detailed instructions available at https://gcc.gnu.org/install/\n" +
            "\n" +
            "Mac OS X Installation\n" +
            "If you use Mac OS X, the easiest way to obtain GCC is to download the Xcode development environment from Apple's website and follow the simple installation instructions.\n" +
            "\n" +
            "Xcode is currently available at developer.apple.com/technologies/tools/.\n" +
            "\n" +
            "Windows Installation\n" +
            "To install GCC at Windows you need to install MinGW. To install MinGW, go to the MinGW homepage, www.mingw.org, and follow the link to the MinGW download page. Download the latest version of the MinGW installation program which should be named MinGW-<version>.exe.\n" +
            "\n" +
            "While installing MinGW, at a minimum, you must install gcc-core, gcc-g++, binutils, and the MinGW runtime, but you may wish to install more.\n" +
            "\n" +
            "Add the bin subdirectory of your MinGW installation to your PATH environment variable so that you can specify these tools on the command line by their simple names.\n" +
            "\n" +
            "When the installation is complete, you will be able to run gcc, g++, ar, ranlib, dlltool, and several other GNU tools from the Windows command line.";

    private String helloWorld = "Let us begin by writing our first C++ program that prints the message \"hello, world\" on the display console.\n" +
            "\n" +
            "Step 1: Write the Source Code: Enter the following source codes using a programming text editor (such as NotePad++ for Windows or gedit for UNIX/Linux/Mac) or an Interactive Development Environment (IDE) (such as CodeBlocks, Eclipse, NetBeans or Visual Studio - Read the respective \"How-To\" article on how to install and get started with these IDEs).\n" +
            "\n" +
            "Do not enter the line numbers (on the left panel), which were added to help in the explanation. Save the source file as \"hello.cpp\". A C++ source file should be saved with a file extension of \".cpp\". You should choose a filename which reflects the purpose of the program.\n" +
            "\n" +
            " * First C++ program that says hello (hello.cpp)\n" +
            " */\n" +
            "#include <iostream>    // Needed to perform IO operations\n" +
            "using namespace std;\n" +
            " \n" +
            "int main() {                        // Program entry point\n" +
            "   cout << \"hello, world\" << endl;  // Say Hello\n" +
            "   return 0;                        // Terminate main()\n" +
            "}                                   // End of main function/* ...... */\n" +
            "// ... until the end of the line\n" +
            "These are called comments. Comments are NOT executable and are ignored by the compiler; but they provide useful explanation and documentation to your readers (and to yourself three days later). There are two kinds of comments:\n" +
            "\n" +
            "Multi-line Comment: begins with /* and ends with */. It may span more than one lines (as in Lines 1-3).\n" +
            "End-of-line Comment: begins with // and lasts until the end of the current line (as in Lines 4, 7, 8, 9 and 10).\n" +
            "#include <iostream>\n" +
            "using namespace std;\n" +
            "The \"#include\" is called a preprocessor directive. Preprocessor directives begin with a # sign. They are processed before compilation. The directive \"#include <iostream>\" tells the preprocessor to include the \"iostream\" header file to support input/output operations. The \"using namespace std;\" statement declares std as the default namespace used in this program. The names cout and endl, which is used in this program, belong to the std namespace. These two lines shall be present in all our programs. I will explain their meaning later.\n" +
            "\n" +
            "int main() { ... body ... }\n" +
            "defines the so-called main() function. The main() function is the entry point of program execution. main() is required to return an int (integer).\n" +
            "\n" +
            "cout << \"hello, world\" << endl;\n" +
            "\"cout\" refers to the standard output (or Console OUTput). The symbol << is called the stream insertion operator (or put-to operator), which is used to put the string \"hello, world\" to the console. \"endl\" denotes the END-of-Line or newline, which is put to the console to bring the cursor to the beginning of the next line.\n" +
            "\n" +
            "return 0;\n" +
            "terminates the main() function and returns a value of 0 to the operating system. Typically, return value of 0 signals normal termination; whereas value of non-zero (usually 1) signals abnormal termination. This line is optional. C++ compiler will implicitly insert a \"return 0;\" to the end of the main() function.";
}




