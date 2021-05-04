using System;

namespace jokenpo
{
    public class Jokenpo
    {
        int init = 1;
        int limit = 3;

        public string PlayJokenpoAndPrintResult(int player)
        {
            int machinePlay = GenerateMachinePlay();
            return CalculatePlays(machinePlay, player);
        }

        public int GenerateMachinePlay()
        {
            var random = new Random();
            var play = random.Next(init, limit);

            return play;
        }

        public string PrintResultTranslated(int result, bool isWinner)
        {
            var resultToPrint = (JokenpoDictionary)result;

            return isWinner ? 
                $"Well done! you played {resultToPrint} and win!!"
                : $"Oh no! you played {resultToPrint} an loss!!";

        }

        public string CalculatePlays(int machinePlay, int userPlay)
        {
            var machinePlayConverted = (JokenpoDictionary)machinePlay;
            var userPlayConverted = (JokenpoDictionary)userPlay;

            if(machinePlay == userPlay){
                return $"A tie!! play again.";
            }
            else
            {
                if((machinePlayConverted == JokenpoDictionary.razor 
                && userPlayConverted == JokenpoDictionary.rock)
                || (machinePlayConverted == JokenpoDictionary.paper 
                && userPlayConverted == JokenpoDictionary.razor)
                || (machinePlayConverted == JokenpoDictionary.rock 
                && userPlayConverted == JokenpoDictionary.paper))
                {
                    return PrintResultTranslated(userPlay, true);
                }
                else
                {
                    return PrintResultTranslated(userPlay, false);
                }
            }
        }

        public void StartJokenpo()
        {
            string result;
            int player;

            Console.WriteLine("Do you play!! \n1 - Rock \n2 - Paper \n3 - Razor");
            player = Convert.ToInt16(Console.ReadLine());
            
            Console.WriteLine("Jokenpo!!");

            result = PlayJokenpoAndPrintResult(player);
            Console.WriteLine($"The result is: {result}");
        }

        public enum JokenpoDictionary
        {
            rock = 1,
            paper = 2,
            razor = 3
        }
    }
}
