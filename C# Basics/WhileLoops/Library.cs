using System;

namespace WhileExercices
{
    class Program
    {
        static void Main(string[] args)
        {
            string book = Console.ReadLine();

            int counter = 0;
            bool bookFound = false;
            string output = string.Empty;

            string currentBook = Console.ReadLine();
            while (currentBook != "No More Books")
            {
                currentBook = Console.ReadLine();
                counter++;

                if (currentBook == book)
                {
                    bookFound = true;
                    output = $"You checked {counter} books and found it.";
                    break;
                }
            }

            if (!bookFound)
            {
                output = $"The book you search is not here!\nYou checked {counter} books.";
            }
           
            Console.WriteLine(output);
        }
    }
}