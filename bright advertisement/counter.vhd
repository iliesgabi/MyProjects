library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity UP_COUNTER is
    Port ( clk: in std_logic;
          qout: out std_logic_vector(1 downto 0)
     );
end UP_COUNTER;

ARCHITECTURE behavioral OF UP_COUNTER IS
	SIGNAL counter : STD_LOGIC_VECTOR(1 DOWNTO 0) :="00";

BEGIN	 
	qout<=counter;
    PROCESS(clk)
    BEGIN
        IF( clk='1' and clk'event )THEN
                counter <= counter + '1'; 						  
        END IF;
    END PROCESS;

END behavioral;