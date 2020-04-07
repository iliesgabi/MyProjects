library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity final is
	port(cuvant: in std_logic_vector(1 downto 0);
		mod_afisare: in std_logic_vector(2 downto 0);
		clk: in std_logic;					
		an: out std_logic_vector(3 downto 0);
		cat: out std_logic_vector(6 downto 0));
end final;

architecture arh of final is 

component seven_segment_display is
    Port ( clk : in STD_LOGIC;
		     word: STD_LOGIC_VECTOR (19 downto 0);
           an : out STD_LOGIC_VECTOR (3 downto 0);
           cat : out STD_LOGIC_VECTOR (6 downto 0));
end component;

component registru is
	port(mod_afisare: in std_logic_vector(2 downto 0);	
	cuvant: in std_logic_vector(1 downto 0);
	clk: in std_logic;					 
	word: out std_logic_vector(19 downto 0));
end component;

component divizor is
port (
   clk_in: in std_logic; -- clock input on FPGA
   clk_out: out std_logic -- clock output 
  );
end component;

signal word: std_logic_vector(19 downto 0);	  
signal clk2: std_logic;

begin
c0 :divizor port map(clk, clk2);
c1: registru port map(mod_afisare, cuvant, clk2, word);
c2: seven_segment_display port map(clk, word, an, cat);		   

end arh;
		