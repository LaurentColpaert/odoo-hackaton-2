package controller;

import database.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Capsule;
import model.Experience;
import utils.Login;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class ExperienceController {

    private final ArrayList<String> country = new ArrayList(Arrays.asList("Afghanistan (AF)","Åland Islands (AX)","Albania (AL)","Algeria (DZ)","American Samoa (AS)","Andorra (AD)","Angola (AO)","Anguilla (AI)","Antarctica (AQ)","Antigua & Barbuda (AG)","Argentina (AR)","Armenia (AM)","Aruba (AW)","Australia (AU)","Austria (AT)","Azerbaijan (AZ)","Bahamas (BS)","Bahrain (BH)","Bangladesh (BD)","Barbados (BB)","Belarus (BY)","Belgium (BE)","Belize (BZ)","Benin (BJ)","Bermuda (BM)","Bhutan (BT)","Bolivia (BO)","Bosnia & Herzegovina (BA)","Botswana (BW)","Bouvet Island (BV)","Brazil (BR)","British Indian Ocean Territory (IO)","British Virgin Islands (VG)","Brunei (BN)","Bulgaria (BG)","Burkina Faso (BF)","Burundi (BI)","Cambodia (KH)","Cameroon (CM)","Canada (CA)","Cape Verde (CV)","Caribbean Netherlands (BQ)","Cayman Islands (KY)","Central African Republic (CF)","Chad (TD)","Chile (CL)","China (CN)","Christmas Island (CX)","Cocos (Keeling) Islands (CC)","Colombia (CO)","Comoros (KM)","Congo - Brazzaville (CG)","Congo - Kinshasa (CD)","Cook Islands (CK)","Costa Rica (CR)","Côte d’Ivoire (CI)","Croatia (HR)","Cuba (CU)","Curaçao (CW)","Cyprus (CY)","Czechia (CZ)","Denmark (DK)","Djibouti (DJ)","Dominica (DM)","Dominican Republic (DO)","Ecuador (EC)","Egypt (EG)","El Salvador (SV)","Equatorial Guinea (GQ)","Eritrea (ER)","Estonia (EE)","Eswatini (SZ)","Ethiopia (ET)","Falkland Islands (FK)","Faroe Islands (FO)","Fiji (FJ)","Finland (FI)","France (FR)","French Guiana (GF)","French Polynesia (PF)","French Southern Territories (TF)","Gabon (GA)","Gambia (GM)","Georgia (GE)","Germany (DE)","Ghana (GH)","Gibraltar (GI)","Greece (GR)","Greenland (GL)","Grenada (GD)","Guadeloupe (GP)","Guam (GU)","Guatemala (GT)","Guernsey (GG)","Guinea (GN)","Guinea-Bissau (GW)","Guyana (GY)","Haiti (HT)","Heard & McDonald Islands (HM)","Honduras (HN)","Hong Kong SAR China (HK)","Hungary (HU)","Iceland (IS)","India (IN)","Indonesia (ID)","Iran (IR)","Iraq (IQ)","Ireland (IE)","Isle of Man (IM)","Israel (IL)","Italy (IT)","Jamaica (JM)","Japan (JP)","Jersey (JE)","Jordan (JO)","Kazakhstan (KZ)","Kenya (KE)","Kiribati (KI)","Kuwait (KW)","Kyrgyzstan (KG)","Laos (LA)","Latvia (LV)","Lebanon (LB)","Lesotho (LS)","Liberia (LR)","Libya (LY)","Liechtenstein (LI)","Lithuania (LT)","Luxembourg (LU)","Macao SAR China (MO)","Madagascar (MG)","Malawi (MW)","Malaysia (MY)","Maldives (MV)","Mali (ML)","Malta (MT)","Marshall Islands (MH)","Martinique (MQ)","Mauritania (MR)","Mauritius (MU)","Mayotte (YT)","Mexico (MX)","Micronesia (FM)","Moldova (MD)","Monaco (MC)","Mongolia (MN)","Montenegro (ME)","Montserrat (MS)","Morocco (MA)","Mozambique (MZ)","Myanmar (Burma) (MM)","Namibia (NA)","Nauru (NR)","Nepal (NP)","Netherlands (NL)","New Caledonia (NC)","New Zealand (NZ)","Nicaragua (NI)","Niger (NE)","Nigeria (NG)","Niue (NU)","Norfolk Island (NF)","North Korea (KP)","North Macedonia (MK)","Northern Mariana Islands (MP)","Norway (NO)","Oman (OM)","Pakistan (PK)","Palau (PW)","Palestinian Territories (PS)","Panama (PA)","Papua New Guinea (PG)","Paraguay (PY)","Peru (PE)","Philippines (PH)","Pitcairn Islands (PN)","Poland (PL)","Portugal (PT)","Puerto Rico (PR)","Qatar (QA)","Réunion (RE)","Romania (RO)","Russia (RU)","Rwanda (RW)","Samoa (WS)","San Marino (SM)","São Tomé & Príncipe (ST)","Saudi Arabia (SA)","Senegal (SN)","Serbia (RS)","Seychelles (SC)","Sierra Leone (SL)","Singapore (SG)","Sint Maarten (SX)","Slovakia (SK)","Slovenia (SI)","Solomon Islands (SB)","Somalia (SO)","South Africa (ZA)","South Georgia & South Sandwich Islands (GS)","South Korea (KR)","South Sudan (SS)","Spain (ES)","Sri Lanka (LK)","St. Barthélemy (BL)","St. Helena (SH)","St. Kitts & Nevis (KN)","St. Lucia (LC)","St. Martin (MF)","St. Pierre & Miquelon (PM)","St. Vincent & Grenadines (VC)","Sudan (SD)","Suriname (SR)","Svalbard & Jan Mayen (SJ)","Sweden (SE)","Switzerland (CH)","Syria (SY)","Taiwan (TW)","Tajikistan (TJ)","Tanzania (TZ)","Thailand (TH)","Timor-Leste (TL)","Togo (TG)","Tokelau (TK)","Tonga (TO)","Trinidad & Tobago (TT)","Tunisia (TN)","Turkey (TR)","Turkmenistan (TM)","Turks & Caicos Islands (TC)","Tuvalu (TV)","U.S. Outlying Islands (UM)","U.S. Virgin Islands (VI)","Uganda (UG)","Ukraine (UA)","United Arab Emirates (AE)","United Kingdom (GB)","United States (US)","Uruguay (UY)","Uzbekistan (UZ)","Vanuatu (VU)","Vatican City (VA)","Venezuela (VE)","Vietnam (VN)","Wallis & Futuna (WF)","Western Sahara (EH)","Yemen (YE)","Zambia (ZM)","Zimbabwe (ZW)"));
    public DatePicker date_experience;

    private Stage stage;

    @FXML
    private CheckBox happy_chechbox;

    @FXML
    private CheckBox neutral_chechbox;

    @FXML
    private ComboBox<String> place_choice;

    @FXML
    private Button return_button;

    @FXML
    private CheckBox sad_chechbox;

    @FXML
    private Button send_button;

    @FXML
    private ComboBox<String> tag_choice;

    @FXML
    private TextArea textarea_descriptoion;

    @FXML
    private CheckBox veryhappy_chechbox;

    @FXML
    private CheckBox verysad_chechbox;

    @FXML
    void click_return(ActionEvent event) {
        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));

            Parent root  = loader.load();
            MenuController main = loader.getController();
            main.setup();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    private void retrieve_info(){
        String tag = tag_choice.getValue();
        String place = place_choice.getValue();
        LocalDate localDate = date_experience.getValue();
        String description = textarea_descriptoion.getText();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);

        String desc = textarea_descriptoion.getText();


        Capsule capsule = Login.getInstance().getCapsule();
        Experience experience = new Experience(capsule.getId_capsule(), strDate,place,new ArrayList<String>(Collections.singleton(tag)),desc);
        Request.insertExperience(experience);
    }
    @FXML
    void clicked_send(ActionEvent event) {
        retrieve_info();
        send_to_db();

        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messageforsentballoon.fxml"));

            Parent root  = loader.load();
            MessageSentBalloonController main = loader.getController();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }



    private void send_to_db() {

    }

    public void setStage(Stage stage){
        this.stage = stage;
        // For action on close
//        this.stage.setOnCloseRequest(event -> client.logOut());

    }

    private void setup_tag_choice(){
        ArrayList<String> tags = Request.getTags();
        for (String tag: tags){
            tag_choice.getItems().add(tag);
        }
    }
    private void setup_place_tag(){
        for(String str:country){
            place_choice.getItems().add(str);
        }
    }
    public void setup(){
        setup_tag_choice();
        setup_place_tag();
        setup_mood_radios();
    }

    private void setup_mood_radios() {

    }

}
