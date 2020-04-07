library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.std_logic_unsigned.all;  

entity seven_segment_display is
    Port ( clk : in STD_LOGIC;
		   word: STD_LOGIC_VECTOR (19 downto 0);
           an : out STD_LOGIC_VECTOR (3 downto 0);
           cat : out STD_LOGIC_VECTOR (6 downto 0));
end seven_segment_display;

architecture Behavioral of seven_segment_display is	 

signal LED_BCD: STD_LOGIC_VECTOR (4 downto 0); 

signal refresh_counter: STD_LOGIC_VECTOR (15 downto 0);
				   
signal LED_activating_counter: std_logic_vector(1 downto 0);

begin  	
	
process(LED_BCD)
begin
    case LED_BCD is
    when "00000" => cat<=  "1111111"; -- space     
    when "00001" => cat<=  "0001000"; -- A 
    when "00010" => cat<=  "0000011"; -- b
    when "00011" => cat<=  "1000110"; -- c 
    when "00100" => cat<=  "0100001"; -- d 
    when "00101" => cat<=  "0000110"; -- E 
    when "00110" => cat<=  "0001110"; -- F 
    when "00111" => cat<=  "0000010"; -- G 
    when "01000" => cat<=  "0001001"; -- H     
    when "01001" => cat<=  "1111001"; -- I 
    when "01010" => cat<=  "1100001"; -- J
    when "01011" => cat<=  "0001111"; -- k
    when "01100" => cat<=  "1000111"; -- L
    when "01101" => cat<=  "0101010"; -- m
    when "01110" => cat<=  "0101011"; -- n
    when "01111" => cat<=  "1000000"; -- O
	 when "10000" => cat<=  "0001100"; -- P
	 when "10001" => cat<=  "0101111"; -- r
	 when "10010" => cat<=  "0010010"; -- S
	 when "10011" => cat<=  "1001110"; -- T
	 when "10100" => cat<=  "1000001"; -- U
	 when "10101" => cat<=  "1100011"; -- v
    when "10110" => cat<=  "1001111"; -- 1
    when "10111" => cat<=  "0010010"; -- 2
    when "11000" => cat<=  "0000110"; -- 3
    when "11001" => cat<=  "1001100"; -- 4 
    when "11010" => cat<=  "0100100"; -- 5
    when "11011" => cat<=  "0001111"; -- 7
    when "11101" => cat<= "0000000"; -- 8
    when "11110" => cat<= "0000100"; -- 9

	when others => cat<= "1111111";  -- none
    end case;
end process;   

process(clk)
begin 
    if(clk='1' and clk'event) then
        refresh_counter <= refresh_counter + '1';
    end if;
end process;
LED_activating_counter <= refresh_counter(15 downto 14); 


process(LED_activating_counter, word)
begin
    case LED_activating_counter is
    when "00" =>
        an <= "0111";
        LED_BCD <= word(19 downto 15);
    when "01" =>
        an <= "1011"; 
        LED_BCD <= word(14 downto 10);
    when "10" =>
        an <= "1101"; 
        LED_BCD <= word(9 downto 5);
    when "11" =>
        an <= "1110"; 
        LED_BCD <= word(4 downto 0);     
	when others => 
		an <= "1110"; 
        LED_BCD <= word(4 downto 0);  
    end case; 
end process;			  


end Behavioral;