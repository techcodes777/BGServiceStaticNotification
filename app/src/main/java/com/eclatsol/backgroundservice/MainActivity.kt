package com.eclatsol.backgroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //Service ek android nu component che
    //Long running operation perform(execute) karava che background ma without any user interaction
    //Service bg ma run thay che
    //App bg ma hoi ke je pan activity component broadcast component e service start kari che te destroy thay jay to pan service chalu rahe che
    //Bg task perform karvani jarur pade tyare apne service no use kari shakvi shavi
    //Android ma tran service hoi che
    //1.foreground service
    //2.background service
    //3.bound service

    //1.foreground service

    //Foreground service banavo shavo to  teno matlab e thay che tame je pan task karo shavo te user ne tame notify karsho using notification
    //For ex koi file download karvi che server per thi internet thi
    //User ni file download thay che ketla percentage download thay che te apne tatavi shavi te che foreground service
    //Jethi user aware rahshe atla percentage file download thay che
    //Foreground service ma user aware rahe che

    //2.background service run thay che tem user aware nathi hoto

    //app mathi data nu backup levi shavi server per thi to te service bg ma run thay user ne khbar pan nai hoi
    //App ma bg service chalu che aa che back ground service

    //3.bound service
    //Je component thi apne service start karvi shavvi
    //For ex. tame activity thi service start karo shavo ,activity ne bound karo shavo service ni sathe ,communication mate
    //For ex. tamrari pase music app che music app ma tame music play karo shavo service ni andar
    //Music ne forward ,stop, rewind karva mate apne code karvo padshe
    //activity ni andar thi service ne command mokalva mate ek interface banavu padshe
    //inter - communication karvi shavi activity(Component) and service ni vache // inter-communication between activity and service
    //tene apne bound service kahvi shavi
    //service apni server hoi che
    //activity(component) apni client hoi che
    //client-server communication ipc pan kahvi shavi

    //service start karo shavo to alag alag state hoi che
    //Started LifeCycle(UnBound) LifeCycle
    //Bounded LifeCycle

    //Started LifeCycle(UnBound) LifeCycle(Background Service)
    //Service ne start karvi shavi start method thi activity and broadcast receiver mathi
    //Jevi service create thahse atle onCreate method call thashe
    //Pasi onStartCommand call thashe
    //onCreate method ek j var call thashe  //First time onCreate then onStart in Service
    //Pasi jetli var service start karsho atle onStartCommandCall thashe
    //onStartCommand ma intent malshe apne //Intent ne pass karishu startService ma
    //onStartCommand ma apne ne id pan malshe //aa service start thay che kaya task mate thay che
    //startid no matlab kai job mate service ne start kari che
    //onStartCommand call thay gaya pasi service running thay che
    //Service ne stop karva mate onDestroy ni andar service class ma stopSelf method ne call karvi pade che
    //activity ma stopService kari ne method call karvi pade che
    //Task puru thay jay atle service stop thashe  //onDestroy method call thay che
    //Koi pan component bound notu //koi communication pan


    //Bounded LifeCycle
    //Koi activity(Component) service ne start kare che bindService method thi, te hoi che bound service
    //Pela onCreate method call thashe tema apne basic initialization karishu
    //Pasi onBind method call thashe tema apne define karishu kevi rite communication karishu
    //Binding nu communication onBind ni andar define karishu -activity and service kevi rite communication karshe
    //Binding interface banavishu iBinder no object hoi che onBind method ma return karvo padshe
    //Koi pan service banavo shavo to tema apne onBind method ne return karvu padshe
    //Binding nathi karta to onBind method mathi null return karvu pade che

    //onBind karo shavo binding mate interface che tene return karvu padshe te i-Binder no object hashe
    //onBind method call thay gaya pasi koi pan component service sathe bind thay jay che
    // Client are bound to service //service run thay che

    //onBound service ma koi pan task assign karelo che
    //onBound service koi pan task puru kari de che to service thhi unbind thavu padhe

    //onUnBind callback method che tene system call kare che
    //Notify thay che je component service thi bind hatu te unbind thay che

    //onBound service start service thi alag che
    // stop kevi rite thay onBound Service
    //Jetla pan component service ni sathe bind che te unbind thya jay atle potani rite service destroy thay jashe stop thay jashe
    //Jevu component service thi unbind thashe atle service destroy thay jashe service shutdown thashe

    //Service and thread bane alag alag vastu che
    //Service tamari application nu main thread che tema run thay che
    //Service koi task bg ma run kare che bija thread ma nathi karti same thread ma kam kare che //service ma task assign karelo che tena per task kare che service

    //Service ni andar koi intency,database related,network related task karva mate biju thread banavu padshe

    //Service class ne extends karishu apne service class thi tema badhi service ni callback method che
    //Service banava mate tamare sub class ne extends karvu padshe

    //Service ne manifest file ma declare karvi shavi
    //Service ne internally use karva mangvi shavi
    //outside of application mate service expoert = true karvu padshe //Externally use karvi shavi
    //Mare service ne outside (Bija)component thi start nathi karavi


    //Normal (UnBound) service ma onCreate mehod ma apne basic initialization karishu
    //For ex. service ma network use karo shavo //network ni repository initialize kari shako shavo
    //Database related kam karo shavo to tame databse ne initialize kari shaku shavu
    //Basic initialization karvi shavi onCreate method ma
    //Koi pan task service ma perform(Run) karo shavo te main thread ma run thay che tama tamari app stuck thashe

    //Service tamari start thay ane te kill thay gay pasi fari kevi riete start karishu
    //Alag alag flag che start sticky ,start not sticky ,start redeliver intent
    //Normal service hathi je bg ma run thay che ui nathi nathi hoti bg ma badho task kare che

    //For ex. music play karvu che ,networking per service perform karvi che ,database operation karvu che tyare apne aa service ne use karvi shavi

    //For ex. service kill thay jay, app kill tbya jay ,system app kill kari de ,koi source no malete to service kill thay jay
    //START_REDELIVER_INTENT ne tame kya use kari shako shavo
    //For ex. file download karo shavo vache thi file download stop thay jay app stop thay jya download baki che tya thi download thashe jyare service start thashe

    //Bound service kevi rite dclare karishu
    //ek component thi bija component ma communication karishu
    //Foreground service kevi rite banavi shakvi

    //Service ek android nu component che
    //BS ma long running task perform kare che
    //Service ni pase interface nathi hotu jem activity,fragment pase interface che
    //Service Another component na through start thya che
    //ActivityComponent,Fragment Component

    //Music player app bg ma chale che//App ne kill kari do ane bg ma app no hoi ne to pan music app chale che

    //Types of Service
    //Foreground Service
    //Background Service
    //Bound Service

    //Real Word Example Joiyeshu service work kem kare
    //Counter type ni app thay gay
    //Bg ma counter app rakhshu ne toi counter increase thase

    //onBind override method je che tene apne Bound Service ma use karishu

    //Service ni pase potani lifecycle hoi che
    //onCreate,Destroy

    //Counter ni increase karvu che dar ek second pasi
    //Counter dar var increase karavu che ane ui ni andar show karavu che counter to onStartCommand method ne hu override karish

    //onStart command int return karshe //Super.onStartCommand remove kari return ma START_STICKY ne call kari do
    //onStart command tran vastu return kar che //Service return kare che
    //START_STICKY,START_NOT_STICKY,START_REDELIVER_INTENT

    //START_STICKY no matlab
    //tame service start kari //Android system apni service ne kill kari dithi //Source nathi mali atle service kill
    //Service to kill thay gai che service ne fari restart kari do resource mali jay to
    //Counter 1 to 10 sudhi puru thay gayu me service restart karavi to pasi 0 thi start thashe 11 thi nai thay
    //Data ne preserve nathi rakhtu ,Datat lost thay che START_STICKY fari restart thashe

    //START_NOT_STICKY no matlab
    //Jo Resource nathi malto apni service kill thay gai fari service automatically start nahi kare
    //Potani jate service start karvi padshe

    //START_REDELIVER_INTENT no matlab
    //Service fari restart thshe jo resource male atle
    //Counter 0 to 10 sudhi puru thay jashe pasi te counter 11 thi start thashe //Data lost nathi thata //Data ne preserve kare che

    //Counter ne increment karvu che to hu coroutines no use karish and counter ne delay karish
    //CoroutineScope task ne background ni andar perfrom karavanu kam kare che

    //CoroutineScope ne create kari dithu pan te automaticallly finish nahi thay cancel nahi thay
    //Service pan cancel thay gai to coroutineScope ne cancle pan karvu padshe to ten mate job name no ariable create karishu
    //Becuase coroutineScope job return kare che

    //isRunning kari ne ek variable banavishu  je indicate kareshe  apni service run thay che ke nai
    //while loop ma hu isRunning use kari tya sudhi counter chalshe

    //Counter varible ni je pan data che tene mare composer function ni andar send karvu padshe
    //Aa type ni condition ave ne to apne broadcast receiver no use karishu
    //BroadCast receiver data send karvanu kam karshe koi pan component ni andar like fragment activity
    //Data moklvo che to broadcast receiver na through moklishu
    //To apne IntentFire karvo pade broadcast ni andar

    //Intent ni andar action provide karavi shavi ,BroadCast nu name provide karavu che
    //Intent ma hu counter data moklish
    //sendBroadCast function ne call kari BroadCastReceiver ne fire karvu che

    //ManifestFile service declare kara time export = false true karvanu ave che
    //True no matlab tamari app ne biji another app sathe service nu communication provide karavi shavi

    //Atyare mare another app ni sathe connection nathi karvu //koi data nathi moklvo mare atle hu false pass karish
    //Service ne stop karva mate me button click nathi karu by default selfStop() function hoi che
    //application destroy thashe tyare use thashe stopSelf atle service stop thai jashe
    //app kill nathi kari ,service stop nathi tyare use thashe

    //Bg Service ma issue che te notification show nathi kartu
    //Garrenty nathi detu tame je task bg ma chalavo shavo chalu rahshe
    //Android ma high priority task avo ram mathi tamro task remove kari de che tame
    // joi pan nahi shako task bg ma chalu che ke nai

    //Foreground service garrenty ape che je pan kam tu bg ma chalevesho te chalu rahshe and sathe notification pan show karave che
    //Foreground service chalu rahvano matlab e che bg ma je pan activity karishu te with the help of notification thi avi jashe

    //notification channel ni jarrur pade che
    //service id 0 sivay koi pan number assign kari shako shavo
    //Condition mukishu version o thi uper hashe to notification channel ni jarur padshe
    //Foreground service banavi shavi to user pase permission levi shavi bg task chalvi shvi
    //Foreground service ma apne notification ne pqn push karavi shavi

    //startForeGroundService je method che te latest android ma use thay che
    //startService je che juna android ma use thay che
    //Request code pass kare cho te sampe che ke nai biji activity ma alag hoi che
    //Permission check kare che tyare else mate ne nahi joshe

    //Permission api pasi te onRequestPermissionResult override method ne call kare che
    // Second time per khbar padshe app chalavish permission mali gai che else execute thashe

    //ForeGround service no je pan task che bg ma chale che monitor karva mate sari rite chale che ke nai handler
    //Runnable name no variable banavishu tema apne object assign karishu te extends thashe Runnable thi

    //Pending Intent request code pass karvi shavi te unique hovo joyie alah button mate
    //Alag alag button mate pending intent banavi che teno request code alag alag hovo joiye
    //LastIntent rahshe te traney button assign thay jashe
    //FLAG_UPDATE_CURRENT flag no matla e che no ek var notification avi gay second notification update kari de
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnStartService).setOnClickListener{
            startService(Intent(this,MyService::class.java))
        }

        findViewById<Button>(R.id.btnStopService).setOnClickListener{
            stopService(Intent(this,MyService::class.java))
        }
    }
}