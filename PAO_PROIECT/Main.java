//Lista actiuni
//Creare echipa - gata 1
//Adaugare jucator -gata 2
//Interogare Puncte Echipa - gata 3
//Interogare statistici jucator - gata 4
//Programare meci- gata 5
//Actualizare jucator- gata 7
//Clasament echipe - gata 6
//Cautare jucator - gata 8
//Listare meciuri - gata 9
//Listare meciuri - gata 9
//Ordonarea meciuri dupa EchipaGazda
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import club.Jucator;
import club.FootballService;
import club.StatisticiJucator;
import club.Stadion;
import club.Antrenor;
import club.Echipa;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FootballService footballService = new FootballService(new ArrayList<>(), new ArrayList<>());

        while (true) {
            System.out.println("\nMeniu Football Service:");
            System.out.println("1. Adauga Jucator");
            System.out.println("2. Creare Echipa");
            System.out.println("3. Interogare Puncte Echipa");
            System.out.println("4. Interogare Statistici Jucător");
            System.out.println("5. Programare Meci");
            System.out.println("6. Clasament echipe");
            System.out.println("7. Modifica datele unui jucator");
            System.out.println("8. Afisarea varstei unui jucator");
            System.out.println("9. Listare meciuri");
            System.out.println("10.Ordonare meciuri dupa echipa gazda");

            System.out.println("0. Iesire");
            System.out.print("Alege o opțiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    System.out.println("Adaugare jucator nou:");
                    System.out.print("Nume: ");
                    String nume = scanner.nextLine();

                    System.out.print("Varsta: ");
                    int varsta = scanner.nextInt();

                    scanner.nextLine();
                    System.out.print("Nationalitate: ");
                    String nationalitate = scanner.nextLine();

                    System.out.print("Gen (M/F): ");
                    char gen = scanner.next().charAt(0);

                    scanner.nextLine(); //skip caracterul de final de linie
                    System.out.print("Pozitie: ");
                    String pozitie = scanner.nextLine();

                    System.out.print("Numar Tricou: ");
                    int numarTricou = scanner.nextInt();

                    System.out.print("Goluri: ");
                    int goluri = scanner.nextInt();

                    System.out.print("Asisturi: ");
                    int asistente = scanner.nextInt();

                    System.out.print("Cartonase Galbene: ");
                    int cartonaseGalbene = scanner.nextInt();

                    System.out.print("Cartonase Roșii: ");
                    int cartonaseRosii = scanner.nextInt();


                    footballService.adaugaJucatorComplet(nume, varsta, nationalitate, gen, pozitie, numarTricou, goluri, asistente, cartonaseGalbene, cartonaseRosii);

                    break;
                case 2:
                    System.out.println("Creare echipa noua:");
                    System.out.print("Nume Echipa: ");
                    String numeEchipaCalc = scanner.nextLine();

                    System.out.print("Nume Antrenor: ");
                    String numeAntrenor = scanner.nextLine();

                    System.out.print("Ani de Experienta (Antrenor): ");
                    int aniExperienta = scanner.nextInt();

                    System.out.print("Numar de victorii: ");
                    int victorii = scanner.nextInt();

                    System.out.print("Numar de infrangeri: ");
                    int infrangeri = scanner.nextInt();

                    System.out.print("Numar de egaluri: ");
                    int egaluri = scanner.nextInt();

                    scanner.nextLine(); // Curata buffer-ul

                    ArrayList<String> echipeAntrenate = new ArrayList<>();

                    // apelare metoda
                    footballService.creareEchipa(numeEchipaCalc, numeAntrenor, aniExperienta, echipeAntrenate, victorii, infrangeri, egaluri);
                    break;


                case 3:
                    System.out.print("Introduceti numele echipei pentru a calcula punctele: ");
                    String numeEchipa= scanner.nextLine();

                    // Apel metoda + afiasre
                    int puncte = footballService.calculeazaPuncteEchipa(numeEchipa);
                    if (puncte != -1) {
                        System.out.println("Echipa " + numeEchipa + " are " + puncte + " puncte.");
                    }
                    break;

                case 4:
                    System.out.println("Introdu numele jucatorului pentru statistici:");
                    String numeJucatorStatistici = scanner.nextLine();
                    footballService.interogareStatisticiJucator(numeJucatorStatistici); // Folosind numele jucatorului
                    break;
                case 5:
                    System.out.println("Programare meci nou:");

                    System.out.print("Care este numele echipei gazda? ");
                    String numeEchipaAcasa = scanner.nextLine();
                    Echipa echipaAcasa = footballService.gasesteEchipaDupaNume(numeEchipaAcasa);

                    System.out.print("Care este numele echipei oaspete? ");
                    String numeEchipaOaspeti = scanner.nextLine();
                    Echipa echipaOaspeti = footballService.gasesteEchipaDupaNume(numeEchipaOaspeti);


                    if (echipaAcasa == null || echipaOaspeti == null) {
                        System.out.println("Una dintre echipe nu a fost gasita in sistem.");
                        return;
                    }


                    System.out.print("Introduceti data si ora meciului (yyyy-MM-dd HH:mm): ");
                    String dataOraStr = scanner.nextLine();
                    LocalDateTime dataOra = LocalDateTime.parse(dataOraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));


                    Stadion stadion = new Stadion("Stadionul Central", 10000, "Oras", "Natural", 1990); // Simplificat


                    footballService.programareMeci(echipaAcasa, echipaOaspeti, dataOra, stadion);
                     break;
                case 6:
                    footballService.clasamentEchipe();
                    break;
                case 7:
                    System.out.println("Actualizare date jucator:");
                    System.out.print("Nume: ");
                    String nume1 = scanner.nextLine();

                    System.out.print("Varsta: ");
                    int varsta1 = scanner.nextInt();

                    scanner.nextLine(); // Consumă newline-ul rămas
                    System.out.print("Nationalitate: ");
                    String nationalitate21 = scanner.nextLine();

                    System.out.print("Gen (M/F): ");
                    char gen1 = scanner.next().charAt(0);

                    scanner.nextLine(); // Consumă newline-ul rămas
                    System.out.print("Pozitie: ");
                    String pozitie1 = scanner.nextLine();

                    System.out.print("Numar Tricou: ");
                    int numarTricou1 = scanner.nextInt();

                    System.out.print("Goluri: ");
                    int goluri1 = scanner.nextInt();

                    System.out.print("Cartonase Galbene: ");
                    int cartonaseGalbene1 = scanner.nextInt();

                    System.out.print("Cartonase Roșii: ");
                    int cartonaseRosii1 = scanner.nextInt();
                    scanner.nextLine();

                    // Apelam metoda pentru a actualiza datele jucatorului
                    footballService.actualizeazaJucator(nume1, varsta1, nationalitate21, gen1, pozitie1, numarTricou1, goluri1, cartonaseGalbene1, cartonaseRosii1);
                    break;
                case 8:
                    System.out.println("Cautare jucator dupa nume:");
                    System.out.print("Introduceti numele jucatorului: ");
                    String numeCautat = scanner.nextLine();

                    Jucator jucatorCautat = footballService.cautaJucatorDupaNume(numeCautat);
                    if (jucatorCautat != null) {
                        System.out.println("Jucatorul " + jucatorCautat.getNume() + " are varsta de " + jucatorCautat.getVarsta() + " ani.");
                    } else {
                        System.out.println("Jucatorul cu numele " + numeCautat + " nu a fost gasit.");
                    }
                    break;
                case 9:
                    footballService.listeazaMeciuri();
                    break;
                case 10:
                    footballService.listeazaMeciuriSortateDupaEchipaAcasa();
                    break;


                case 0:
                    System.out.println("Iesire din program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida. Te rog sa alegi din nou.");
                    break;
            }
        }
    }
}