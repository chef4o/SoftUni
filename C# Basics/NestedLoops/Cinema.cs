using System;

namespace Cinema
{
    class Program
    {
        static void Main(string[] args)
        {

            int seats = 0;
            int standardTickets = 0;
            int studentTickets = 0;
            int kidsTickets = 0;

            string movieName = Console.ReadLine();
            while (movieName != "Finish")
            {
                int capacity = int.Parse(Console.ReadLine());

                string ticketType = Console.ReadLine();
                    while (ticketType != "End")
                    {
                        if (ticketType == "standard")
                        {
                            standardTickets++;
                        }
                        else if (ticketType == "student")
                        {
                            studentTickets++;
                        }
                        else if (ticketType == "kid")
                        {
                            kidsTickets++;
                        }

                        seats++;
                        if (seats >= capacity)
                        {
                        break;
                        }
                        ticketType = Console.ReadLine();
                    }

                Console.WriteLine($"{movieName} - {seats * 100.0 / capacity:f2}% full.");
                seats = 0;
                movieName = Console.ReadLine();
            }

            int totalTickets = standardTickets + studentTickets + kidsTickets;

            Console.WriteLine($"Total tickets: {totalTickets}\n" +
                              $"{studentTickets * 100.0 / totalTickets:f2}% student tickets.\n" +
                              $"{standardTickets * 100.0 / totalTickets:f2}% standard tickets.\n" +
                              $"{kidsTickets * 100.0 / totalTickets:f2}% kids tickets.");
            
        }
    }
}
