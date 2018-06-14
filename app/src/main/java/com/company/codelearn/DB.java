package com.company.codelearn;

import java.util.ArrayList;

public class DB {
    private static DB instance = new DB();
    ArrayList<String> lessons = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    private DB() {

        createLessons();
        createTitles();

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

    private String history = "Język C++ został stworzony w latach osiemdziesiątych XX wieku (pierwsza wersja pojawiła się w 1979 r.) przez Bjarne Stroustrupa jako obiektowe rozszerzenie języka C. Poza językiem C, na definicję języka C++ miały wpływ takie języki, jak Simula (z której zaczerpnął właściwości obiektowe) oraz Algol, Ada, ML i Clu.\n" +
            "\n" +
            "Początkowo język C++ był dostępny w takim standardzie, w jakim opracowano ostatnią wersję kompilatora Cfront (tłumaczący C++ na C), później opublikowano pierwszy nieformalny standard zwany ARM (Annotated Reference Manual), który sporządzili Bjarne Stroustrup i Margaret Ellis. Standard języka C++ powstał w 1998 roku (ISO/IEC 14882-1998 \"Information Technology – Programming Languages – C++\"). Standard ten zerwał częściowo wsteczną zgodność z ARM w swojej bibliotece standardowej; jedyne, co pozostało w stanie w miarę nienaruszonym to biblioteka iostream.\n" +
            "\n" +
            "Początkowo najważniejszą zmianą wprowadzoną w C++ w stosunku do C było programowanie obiektowe, później jednak zaimplementowano wiele innych ulepszeń, mających uczynić ten język wygodniejszym i bardziej elastycznym od swojego pierwowzoru. Niektóre zmiany w standardzie języka C były zainspirowane językiem C++ (np. słowo inline w C99).\n" +
            "\n" +
            "Nazwa języka została zaproponowana przez Ricka Mascitti w 1983 roku, kiedy to po raz pierwszy użyto tego języka poza laboratorium naukowym. Odzwierciedla ona fakt, że język ten jest rozszerzeniem języka C. Wcześniej używano nazwy „C z klasami”. Nazwa języka C++ nawiązuje do faktu bycia \"następcą języka C\", przez użycie w niej operatora inkrementacji \"++\". Inkrementacja to zwiększenie liczby o 1, w języku C++ do jej wykonania wykorzystywany jest ww. operator; dla przykładu:\n" +
            "\n" +
            "zapis:\n" +
            "\n" +
            "i=i+1; // zmiennej \"i\" przypisuje jej aktualną wartość, powiększoną o 1\n" +
            "... jest równoważny[a]\n" +
            "\n" +
            "++i; // również powiększa wartość zmiennej \"i\" o 1.\n" +
            "// Uwaga! instrukcja i++ także zwiększa wartość zmiennej, po jej użyciu.\n" +
            "Nazwa C++ jest więc symbolicznym stwierdzeniem, iż jest to język C, unowocześniony, o większych możliwościach.\n" +
            "\n" +
            "Pierwsze kompilatory języka C++, podobnie jak Cfront, były wyłącznie translatorami na język C. Kompilatory takie dostępne są i dziś. Jednym z nich jest Comeau C++ – jeden z niewielu kompilatorów oferujących pełne wsparcie dla standardu języka. Pierwszym kompilatorem natywnym (produkującym od razu kod asemblerowy) dla języka C++ był g++ z pakietu GCC, którego pierwszym autorem był Michael Tiemann, założyciel Cygnus Solutions.";

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

    private String helloWorld = "Wybieramy: File> New> Project… w nowym oknie wybieramy Win32 Console Application i w polu Name podajemy nazwę projektu (obojętnie jaką, byle byśmy sami się później połapali co ten projekt zawiera). Klikamy OK, potem Next> i Finish.\n" +
            "\n" +
            "Zobaczymy w nowo otwartej karcie cząstki kodu – możecie go z czystym sumieniem usunąć. Na tym etapie jest nam to wogóle niepotrzebne.\n" +
            "\n" +
            "4) Jeżeli piszesz w MVS 2010 musisz do kodu dodać bibliotekę stdafx.h Jeżeli korzystasz z innego kompilatora (np. Dev C++) jest ona zbyteczna.\n" +
            "\n" +
            "Gotowe! Jesteście gotowi do pisania swojego pierwszego programu! Zaczynajmy więc \uD83D\uDE42\n" +
            "\n" +
            "Na początek kod:\n" +
            "\n" +
            "#include <stdafx.h>        //Powtarzam: tylko dla MVS 2010\n" +
            "#include <iostream>\n" +
            " \n" +
            "using namespace std;\n" +
            " \n" +
            "int main()\n" +
            "{\n" +
            "    cout<<\"Hello World!\";\n" +
            "    cin.get();\n" +
            "    return 0;\n" +
            "}\n" +
            "Czas na wyjaśnienie:\n" +
            "\n" +
            "#include – z angielskiego w tłumaczeniu znaczy mniej więcej tyle co dołączyć. Sama dyrektywa zawsze musi być poprzedzona # (wiele osób o tym na początku zapomina) i „informuje” program aby dołączył zawartość biblioteki iostream. Po co? Ano w niej zapisano chociażby co znaczy cout. Jeżeli jej zabraknie dla kompilatora nasze cout będzie znaczyło tyle co każde inne słowo więc nie będzie on w stanie skompilować czyli przetłumaczyć dla procesora naszego programu. Bo jak skoro sam go nie rozumie? Dzięki dołączeniu iostream rozumie i sobie kompiluje. Dość wspomnieć, że jest to jedna z podstawowych bibliotek i wykorzystuje się ją chyba zawsze.\n" +
            "\n" +
            "using namespace std; – jest to tak zwana przestrzeń nazw. Pojęcie na początku trochę skomplikowane, ale jeżeli dobrze się wczytasz to obiecuję, że zrozumiesz. Więc tak: w przeciwieństwie do języków pokroju Pascal, C++ jest bardzo rozbudowany i nierzadko jeden projekt to zlepka kilku mniejszych – żeby wam to dobrze przedstawić to posłużę się takim oto porównaniem: Programista_1 pisze funkcję odpowiedzialną za np. otwieranie pliku, Programista_2 pisze funkcję pozwalającą na konwersję pliku, Programista_3 napisze funkcję zamykającą program. Teraz zbierzmy to do kupy. Wyobraźcie sobie, że wszyscy trzej nazwali swoją funkcję File(); I co gdy złożymy je razem? Funkcja otwierająca plik to File(), konwertująca to File() i zamykająca to File(). No to program wywołuje funkcję File() i … właśnie, co? Ma otworzyć, konwertować czy zamknąć plik? Przestrzeń nazw rozwiązuje ten problem – Programista_1 stworzy przestrzeń nazw prog_1 w której to funkcja File() będzie otwierała plik, Programista_2 napisze prog_2 i w tej przestrzeni funkcja File() będzie konwertowała plik zaś Programista_3 stworzy przestrzeń o nazwie prog_3 w której to File() będzie zamykało plik. I gdy teraz program wywoła funkcję File() to sprawdzi w jakiej przestrzeni nazw się ona znajduje i jak ją tam zdefiniowano.\n" +
            "\n" +
            "Pierwsze programy nie będą aż tak rozbudowane by zaistniała konieczność korzystania z kilku przestrzeni. Wystarczy nam standardowa (std to właśnie skrót do „standard”), nie mniej jednak musicie jej używać. W kolejnych lekcjach nauczymy się pisać własne \uD83D\uDE09\n" +
            "\n" +
            "main() – podstawowa, główna funkcja programu. Występuje chyba w każdym programie (istnieją wyjątki, ale można je policzyć na palcach jednej ręki sapera). Jest to główna funkcja wywoływana przez kod startowy (jest on jakby pośrednikiem między programem a systemem). W nawiasach mogą znaleźć się argumenty – czyli informacje jakie kod startowy przekazuje funkcji main(). W tym przypadku nie przyjmuje żadnych więc nawias pozostaje pusty.\n" +
            "\n" +
            "Można też zastosować main(void) jednak za poprawne uznaje się raczej puste nawiasy.\n" +
            "\n" +
            "Dlaczego int widnieje przed nazwą funkcji? Skoro funkcja może przyjmować dane (argumenty) to może je też zwracać (wartości). Nasze int oznacza, że zwraca, void znaczyłoby, że funkcja nie zwraca żadnej wartości.\n" +
            "\n" +
            "{ i } – cóz te nawiasy klamrowe to sygnał dla programu gdzie się kończy a gdzie zaczyna. Coś jak BEGIN i END. w Pascalu.\n" +
            "\n" +
            "cout<< – obiekt wyświetlający tekst na ekranie, chociaż poprawnie brzmiąca definicja to: obiekt wstawiający łańcuch znaków do strumienia wyjściowego. Nasze << oznacza, że znaki znajdujące się za tym operatorem wstawiane są do strumienia wyjściowego. Jeżeli operator byłby skierowany w drugą stronę (>>) to znaki kierowane byłyby do strumienia wejściowego.\n" +
            "\n" +
            "To co chcemy „wyrzucić” userowi na ekran musi znaleźć się w cudzysłowie.\n" +
            "\n" +
            "cin.get(); – czeka na wciśnięcie klawisza. Gdyby go nie było program by zadziałał ale … wyglądałoby to tak: dołączam biblioteki jakie sobie zażyczył programista, sprawdzam przestrzeń nazw, wyświetlam tekst, zamykam program. I wszystko byłoby ok, gdyby nie fakt, że program wykona wszytkie te operacje w ułamku sekundy. Ludzkie oko nie zdąży tego zarejestrować – jedynie mignie nam czarne okienko na pulpicie. Jeżeli zaś dodamy cin.get() program się zatrzyma do wciśnięcia klawisza. Potem dalej będzie pędził.\n" +
            "\n" +
            "return 0 – instrukcja zwracająca jakąś wartość – jaką to już zależy od funkcji. Bardzo często korzysta się z niej do zwracania numerów błędów.";
}




