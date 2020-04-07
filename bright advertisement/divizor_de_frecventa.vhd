library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_UNSIGNED.ALL;
entity divizor is
port (
   clk_in: in std_logic; -- clock input on FPGA
   clk_out: out std_logic -- clock output 
  );
end divizor;

architecture Behavioral of divizor is
signal divisor: std_logic_vector(26 downto 0):= (others => '0');
begin
 process(clk_in)
 begin
 if(clk_in='1' and clk_in'event) then  
	  divisor <= divisor + '1';
 end if;
 end process;

 clk_out <= divisor(26);
end Behavioral;