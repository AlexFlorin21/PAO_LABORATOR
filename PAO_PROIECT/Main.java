//Lista actiuni
//Creare echipa - gata 1
//Adaugare jucator -gata 2
//Interogare Puncte Echipa - gata 3
//Interogare statistici jucator - gata 4
//Programare meci- gata 5
//Actualizare scor meci
//Clasament echipe
//Cautare jucator
//Listare meciuri
//Editare profil echipa
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
            System.out.println("1. Adaugă Jucător");
            System.out.println("2. Creare Echipă");
            System.out.println("3. Interogare Puncte Echipa");
            System.out.println("4. Interogare Statistici Jucător");
            System.out.println("5. Programare Meci");
            System.out.println("0. Ieșire");
            System.out.print("Alege o opțiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă linia nouă rămasă

            switch (optiune) {
                case 1:
                    System.out.println("Adăugare jucător nou:");
                    System.out.print("Nume: ");
                    String nume = scanner.nextLine();

                    System.out.print("Vârstă: ");
                    int varsta = scanner.nextInt();

                    scanner.nextLine(); // Consumă newline-ul rămas
                    System.out.print("Naționalitate: ");
                    String nationalitate = scanner.nextLine();

                    System.out.print("Gen (M/F): ");
                    char gen = scanner.next().charAt(0);

                    scanner.nextLine(); // Consumă newline-ul rămas
                    System.out.print("Poziție: ");
                    String pozitie = scanner.nextLine();

                    System.out.print("Număr Tricou: ");
                    int numarTricou = scanner.nextInt();

                    System.out.print("Goluri: ");
                    int goluri = scanner.nextInt();

                    System.out.print("Asistențe: ");
                    int asistente = scanner.nextInt();

                    System.out.print("Cartonașe Galbene: ");
                    int cartonaseGalbene = scanner.nextInt();

                    System.out.print("Cartonașe Roșii: ");
                    int cartonaseRosii = scanner.nextInt();


                    footballService.adaugaJucatorComplet(nume, varsta, nationalitate, gen, pozitie, numarTricou, goluri, asistente, cartonaseGalbene, cartonaseRosii);

                    break;
                case 2:
                    System.out.println("Creare echipă nouă:");
                    System.out.print("Nume Echipă: ");
                    String numeEchipaCalc = scanner.nextLine();

                    System.out.print("Nume Antrenor: ");
                    String numeAntrenor = scanner.nextLine();

                    System.out.print("Ani de Experiență (Antrenor): ");
                    int aniExperienta = scanner.nextInt();

                    System.out.print("Număr de victorii: ");
                    int victorii = scanner.nextInt();

                    System.out.print("Număr de înfrângeri: ");
                    int infrangeri = scanner.nextInt();

                    System.out.print("Număr de egaluri: ");
                    int egaluri = scanner.nextInt();

                    scanner.nextLine(); // Curăță buffer-ul

                    ArrayList<String> echipeAntrenate = new ArrayList<>(); // Aici se poate extinde pentru a colecta echipe antrenate anterior, dacă este necesar

                    // Apelăm metoda pentru a crea echipa, inclusiv statisticile
                    footballService.creareEchipa(numeEchipaCalc, numeAntrenor, aniExperienta, echipeAntrenate, victorii, infrangeri, egaluri);
                    break;


                case 3:
                    System.out.print("Introduceți numele echipei pentru a calcula punctele: ");
                    String numeEchipa= scanner.nextLine();

                    // Apelăm metoda și afișăm rezultatul
                    int puncte = footballService.calculeazaPuncteEchipa(numeEchipa);
                    if (puncte != -1) { // Dacă echipa a fost găsită și punctele calculate
                        System.out.println("Echipa " + numeEchipa + " are " + puncte + " puncte.");
                    }
                    break;

                case 4:
                    System.out.println("Introdu numele jucătorului pentru statistici:");
                    String numeJucatorStatistici = scanner.nextLine();
                    footballService.interogareStatisticiJucator(numeJucatorStatistici); // Folosind numele jucătorului
                    break;
                case 5:
                    System.out.println("Programare meci nou:");

                    System.out.print("Care este numele echipei gazdă? ");
                    String numeEchipaAcasa = scanner.nextLine();
                    Echipa echipaAcasa = footballService.gasesteEchipaDupaNume(numeEchipaAcasa);

                    System.out.print("Care este numele echipei oaspete? ");
                    String numeEchipaOaspeti = scanner.nextLine();
                    Echipa echipaOaspeti = footballService.gasesteEchipaDupaNume(numeEchipaOaspeti);


                    if (echipaAcasa == null || echipaOaspeti == null) {
                        System.out.println("Una dintre echipe nu a fost găsită în sistem.");
                        return; // Ieșire timpurie dacă una dintre echipe nu există
                    }


                    System.out.print("Introduceți data și ora meciului (yyyy-MM-dd HH:mm): ");
                    String dataOraStr = scanner.nextLine();
                    LocalDateTime dataOra = LocalDateTime.parse(dataOraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));


                    Stadion stadion = new Stadion("Stadionul Central", 10000, "Oras", "Natur", 1990); // Simplificat


                    footballService.programareMeci(echipaAcasa, echipaOaspeti, dataOra, stadion);
                     break;
                case 0:
                    System.out.println("Ieșire din program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opțiune invalidă. Te rog să alegi din nou.");
                    break;
            }
        }
    }
}