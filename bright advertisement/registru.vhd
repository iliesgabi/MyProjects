library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity registru is
	port(mod_afisare: in std_logic_vector(2 downto 0);	
	cuvant: in std_logic_vector(1 downto 0);
	clk: in std_logic;					 
	word: out std_logic_vector(19 downto 0));
end registru;

architecture arh of registru is 
component UP_COUNTER is
    Port ( clk: in std_logic;
          qout: out std_logic_vector(1 downto 0)
     );
end component;

component rom is
	port(cuvant : in std_logic_vector(1 downto 0);	
	clk: in std_logic;
	cuv: out std_logic_vector(19 downto 0)
	);
end component;

signal numarator: std_logic_vector(1 downto 0);		   
signal d:std_logic_vector(19 downto 0);	   
signal appear: std_logic:='0';
begin

c1:rom port map(cuvant,clk,d);
c2:UP_COUNTER port map(clk,numarator);	 

process(clk,mod_afisare,d,numarator)
begin			 

	if (clk='1' and clk'EVENT) then
		case mod_afisare is
			when b"000" => --shiftare dreapta
				case numarator is 
					when "00" =>  
					   word(19 downto 15) <= d(4 downto 0);
						word(14 downto 10) <= d(19 downto 15);
						word(9 downto 5) <= d(14 downto 10);
						word(4 downto 0) <= d(9 downto 5);
					when "01" =>  
						word(19 downto 15) <= d(9 downto 5);
					   word(14 downto 10) <= d(4 downto 0);
						word(9 downto 5) <= d(19 downto 15);
						word(4 downto 0) <= d(14 downto 10);
					when "10" => 	  
						word(19 downto 15) <= d(14 downto 10);
						word(14 downto 10) <= d(9 downto 5);
						word(9 downto 5) <= d(4 downto 0);
						word(4 downto 0) <= d(19 downto 15);
					when "11" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <= d(4 downto 0);	  
					when others => 
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <= d(4 downto 0);
				end case;
			when b"001" => --shiftare stanga
				case numarator is 
					when "00" =>  
					   word(19 downto 15) <= d(14 downto 10);
						word(14 downto 10) <= d(9 downto 5);
						word(9 downto 5) <= d(4 downto 0);
						word(4 downto 0) <= d(19 downto 15);
					when "01" =>  
						word(19 downto 15) <= d(9 downto 5);
					   word(14 downto 10) <= d(4 downto 0);
						word(9 downto 5) <= d(19 downto 15);
						word(4 downto 0) <= d(14 downto 10);
					when "10" => 	  
						word(19 downto 15) <= d(4 downto 0);
						word(14 downto 10) <= d(19 downto 15);
						word(9 downto 5) <= d(14 downto 10);
						word(4 downto 0) <= d(9 downto 5);
					when "11" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <= d(4 downto 0);	  
					when others => 
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <= d(4 downto 0);
				end case;
			when b"010" => --stergere
				case numarator is
					when "00" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <= d(4 downto 0); 	
					when "01" =>
					word(19 downto 15) <= "11111" ;
						word(14 downto 10) <= d(19 downto 15);
						word(9 downto 5) <= d(14 downto 10);
						word(4 downto 0) <=  d(9 downto 5); 
					when "10" =>
				  	   word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= d(19 downto 15);
						word(4 downto 0) <= d(14 downto 10);  
					when "11" =>
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= d(19 downto 15);  	
					when others=> 
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111";
				end case; 
			when b"011" => --afisare litera cu litera
				case numarator is
					when "00" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111"; 
					when "01" =>
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111";  
					when "10" =>
				  	  word(19 downto 15) <= "11111" ;
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <=  "11111"; 
					when "11" =>
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= d(4 downto 0); 	
					when others=> 
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111";
				end case;	
			when b"100" => --afisare 2 cate 2 litere
				case numarator is
					when "00" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= "11111";
						word(9 downto 5) <=  d(9 downto 5);
						word(4 downto 0) <= "11111"; 
					when "01" =>
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= "11111";
						word(4 downto 0) <=  d(4 downto 0);  
					when "10" =>
				  	   word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= "11111";
						word(9 downto 5) <=  d(9 downto 5);
						word(4 downto 0) <= "11111"; 
					when "11" =>
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= "11111";
						word(4 downto 0) <=  d(4 downto 0); 	
					when others=> 
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111";
				end case;
			when b"101" => --formare cuvant
				case numarator is
					when "00" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111"; 
					when "01" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111";  
					when "10" =>
				  	  word(19 downto 15) <= d(19 downto 15) ;
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <=  "11111"; 
					when "11" =>
						word(19 downto 15) <= d(19 downto 15);
						word(14 downto 10) <= d(14 downto 10);
						word(9 downto 5) <= d(9 downto 5);
						word(4 downto 0) <= d(4 downto 0); 	
					when others=> 
						word(19 downto 15) <= "11111";
						word(14 downto 10) <= "11111";
						word(9 downto 5) <= "11111";
						word(4 downto 0) <= "11111";
				end case;
			when b"110" => --clipire
				if appear ='0' then
					word <= x"00000";
					appear<='1';
				else
					word <= d; 
					appear<='0';
				end if;
			when b"111" => --afisare statica
				word <= d;	
			when others => word <= d;
		end case;
	end if;	 
end process;
end arh;