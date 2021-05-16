<?php

function repondre($ask){
    while(true){
        $reponse = readline($ask.'(O)ui / (N)on:');
        if(reponse === 'o'){
            return true ;
        }else if($reponse === 'n'){
            return false ;
        }
    }
}

function demander_creneau($inst = 'Veuillez entrez votre Creneau '){  

    echo $inst ."\n";
    while(true){
        $ouverture = (int)readline('Heure d\'ouverture : ');
        if($ouverture >= 0 && $ouverture <= 23){
            break ;
        }
    }
    while(true){
        $fermeture = (int)readline("Heure de fermeture: ");
        if($fermeture >= 0 && $fermeture <= 23 && $fermeture > $ouverture){
            break ;
        }elseif($fermeture <= $ouverture || $fermeture > 23 || $fermeture < 0 ){
            echo "\n Mauvais(es) Horaire(s) veuilez recommencer ";
        }
    }

    return [$ouverture, $fermeture];
}


function demander_creneaux($phrase = 'Veuillez entrer vos creneaux '){
    echo $phrase . "\n";
    $res = [] ;
    $creneau = demander_creneau('Entrez le premier Creneau'. '\n');
    
    $res[] = $creneau ;
   
    $resp = true ;

    while($resp){
     $res[] = demander_creneau();
     $resp = repondre("Voulez vous continuer: \n");
    }

    return $res ;
}
 demander_creneaux() ;
?>