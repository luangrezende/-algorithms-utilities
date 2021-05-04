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
                $"Parabens! você jogou {resultToPrint} e ganhou!!"
                : $"Vishh! você jogou {resultToPrint} e perdeu!!";

        }

        public string CalculatePlays(int machinePlay, int userPlay)
        {
            var machinePlayConverted = (JokenpoDictionary)machinePlay;
            var userPlayConverted = (JokenpoDictionary)userPlay;

            Console.WriteLine($"eu: {userPlayConverted}");
            Console.WriteLine($"maquina: {machinePlayConverted}");

            if(machinePlay == userPlay){
                return $"Empate!! jogue novamente.";
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

            Console.WriteLine("Faça sua jogada!!!! \n1 - Pedra \n2 - Papel \n3 - Tesoura");
            player = Convert.ToInt16(Console.ReadLine());
            
            Console.WriteLine("Jokenpo!!");

            result = PlayJokenpoAndPrintResult(player);
            Console.WriteLine($"Resultado é: {result}");
        }

        public enum JokenpoDictionary
        {
            rock = 1,
            paper = 2,
            razor = 3
        }
    }
}
