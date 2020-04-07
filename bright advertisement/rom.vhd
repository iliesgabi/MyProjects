library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity rom is
	port(cuvant : in std_logic_vector(1 downto 0);	
	clk: in std_logic;
	cuv: out std_logic_vector(19 downto 0)
	);
end rom;

architecture arh of rom is

type memorie is array(0 to 3) of std_logic_vector(19 downto 0);
signal my_rom : memorie := (
b"00001_10010_10100_10010", --asus
b"00001_01100_00111_00001", --alga
b"00011_01111_01100_00001", --cola
b"00110_10000_00111_00001", --fpga
others => b"00110_10000_00111_00001");
begin
process(clk)
begin
if (clk='1' and clk'event) then
	case cuvant is
		when "00" => cuv<=my_rom(0);
		when "01" => cuv<=my_rom(1);
		when "10" => cuv<=my_rom(2);
		when "11" => cuv<=my_rom(3);
	when others => cuv <= b"00110_10000_00111_00001";
	end case;
end if;
end process;
end arh;