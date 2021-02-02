using System;

namespace AgencyProfit
{
    class Program
    {
        static void Main(string[] args)
        {
            string airline = Console.ReadLine();
            int adultTickets = int.Parse(Console.ReadLine());
            int kidTickets = int.Parse(Console.ReadLine());
            double netTicketPrice = double.Parse(Console.ReadLine());
            double servicePrice = double.Parse(Console.ReadLine());

            double kidTicketPrice = netTicketPrice * (1 - 70.0 / 100);

            double totalPrice = netTicketPrice * adultTickets + kidTicketPrice * kidTickets + (adultTickets + kidTickets) * servicePrice;
            double profit = totalPrice * 20.0 / 100;

            Console.WriteLine($"The profit of your agency from {airline} tickets is {profit:f2} lv.");

        }
    }
}
