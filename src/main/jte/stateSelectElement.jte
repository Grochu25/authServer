@param com.grochu.authserver.Model.RegisterUserDetails userDetails

<select id="country" name="addressState" >
    <option value="">Wybierz województwo</option>
    <option value="Doln" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Doln")}">Dolnośląskie</option>
    <option value="KuPo" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("KuPo")}">Kujawsko-pomorskie</option>
    <option value="Lube" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Lube")}">Lubelskie</option>
    <option value="Lubu" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Lubu")}">Lubuskie</option>
    <option value="Lodz" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Lodz")}">Łódzkie</option>
    <option value="Malo" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Malo")}">Małopolskie</option>
    <option value="Mazo" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Mazo")}">Mazowieckie</option>
    <option value="Opol" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Opol")}">Opolskie</option>
    <option value="Podk" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Podk")}">Podkarpackie</option>
    <option value="Podl" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Podl")}">Podlaskie</option>
    <option value="Pomo" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Pomo")}">Pomorskie</option>
    <option value="Slas" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Slas")}">Śląskie</option>
    <option value="Swie" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Swie")}">Świętokrzyskie</option>
    <option value="WaMa" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("WaMa")}">Warmińsko-mazurskie</option>
    <option value="Wiel" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Wiel")}">Wielkopolskie</option>
    <option value="Zach" selected="${userDetails.getAddressState() != null && userDetails.getAddressState().equals("Zach")}">Zachodniopomorskie</option>
</select><br/>
