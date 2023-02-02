using Jokenpo.Enum;
using System;

namespace jokenpo
{
    public class Jokenpo
    {
        readonly int init = 1;
        readonly int limit = 3;

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

        public static string PrintResultTranslated(JokenpoEnum playerPlay, JokenpoEnum machinePlay, bool isWinner)
        {
            return isWinner ? 
                $"Well done! you played {playerPlay} and Machine played {machinePlay}, so you win!!"
                : $"Oh no! you played {playerPlay} and Machine played {machinePlay}, so you loss!!";

        }

        public static string CalculatePlays(int machinePlay, int userPlay)
        {
            var userPlayConverted = (JokenpoEnum)userPlay;
            var machinePlayConverted = (JokenpoEnum)machinePlay;

            string result = CalculatePlay(userPlayConverted, machinePlayConverted);

            return result switch
            {
                "WIN" => PrintResultTranslated(userPlayConverted, machinePlayConverted, true),
                "LOST" => PrintResultTranslated(userPlayConverted, machinePlayConverted, false),
                _ => $"A tie!! play again.",
            };
        }

        private static string CalculatePlay(JokenpoEnum player, JokenpoEnum machine)
        {
            if (player == machine)
            {
                return "TIE";
            }

            if (player == JokenpoEnum.rock
                && machine == JokenpoEnum.razor)
            {
                return "WIN";
            }

            if (player == JokenpoEnum.paper
                && machine == JokenpoEnum.rock)
            {
                return "WIN";
            }

            if (player == JokenpoEnum.razor
                && machine == JokenpoEnum.paper)
            {
                return "WIN";
            }


            return "LOST";
        }

        public void StartJokenpo()
        {
            Console.WriteLine("Make your choice!! \n1 - Rock \n2 - Paper \n3 - Razor");
            int playerPlay = Convert.ToInt16(Console.ReadLine());

            int enumCount = Enum.GetNames(typeof(JokenpoEnum)).Length;

            if (playerPlay > enumCount)
            {
                Console.WriteLine($"Sorry but you have only {enumCount} options.");
                StartAgain();
            }
            
            Console.WriteLine("Jokenpo!!");

            string result = PlayJokenpoAndPrintResult(playerPlay);
            Console.WriteLine(result);

            StartAgain();
        }

        private void StartAgain()
        {
            Console.WriteLine("................................");
            StartJokenpo();
        }
    }
}
