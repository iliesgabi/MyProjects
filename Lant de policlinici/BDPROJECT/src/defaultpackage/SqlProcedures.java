package defaultpackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;

public class SqlProcedures {
	static ResultSet isAdmin(Connection con, String cnp, String password) throws SQLException {
		CallableStatement cs = con.prepareCall("{call isAdmin(?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, password);
		cs.execute();
		return cs.getResultSet();
	}

	static void addAdmin(Connection con, String cnp, String username, String password) throws SQLException {
		CallableStatement cs = con.prepareCall("{call addAdmin(?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, username);
		cs.setString(3, password);
		cs.execute();
	}

	static void addCommonUserLogin(Connection con, String cnp, String username, String password) throws SQLException {
		CallableStatement cs = con.prepareCall("{call addCommonUserLogin(?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, username);
		cs.setString(3, password);
		cs.execute();
	}

	static void addCommonUserDatePers(Connection con, String cnp, String nume, String prenume, String adresa,
			String telefon, String email, String cont_IBAN, String nr_contract, String year, String month, String day,
			String functie) throws SQLException {
		CallableStatement cs = con.prepareCall("{call addCommonUserDatePers(?,?,?,?,?,?,?,?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, nume);
		cs.setString(3, prenume);
		cs.setString(4, adresa);
		cs.setString(5, telefon);
		cs.setString(6, email);
		cs.setString(7, cont_IBAN);
		cs.setString(8, nr_contract);
		cs.setString(9, year + ":" + month + ":" + day);
		cs.setString(10, functie);
		cs.execute();
	}

	static void addAngajat(Connection con, String cnp, Integer salariu, Integer nrOre, Integer tipOrar)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call addAngajat(?,?,?,?)}");
		cs.setString(1, cnp);
		cs.setInt(2, salariu);
		cs.setInt(3, nrOre);
		cs.setInt(4, tipOrar);
		cs.execute();
	}

	static void addAsistent(Connection con, String cnp, String tip, String grad) throws SQLException {
		CallableStatement cs = con.prepareCall("{call addAsistent(?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, tip);
		cs.setString(3, grad);
		cs.execute();
	}

	static void addMedic(Connection con, String cnp, String grad, String cod_parafa, String titlu_stiintific,
			String post_didactic, Integer procent_servicii) throws SQLException {
		CallableStatement cs = con.prepareCall("{call addMedic(?,?,?,?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, grad);
		cs.setString(3, cod_parafa);
		cs.setString(4, titlu_stiintific);
		cs.setString(5, post_didactic);
		cs.setInt(6, procent_servicii);
		cs.execute();
	}

	static void deleteAdmin(Connection con, String cnp, String username, String password) throws SQLException {
		CallableStatement cs = con.prepareCall("{call deleteAdmin(?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, username);
		cs.setString(3, password);
		cs.execute();
	}

	static void deleteUser(Connection con, String cnp, String username, String password) throws SQLException {
		CallableStatement cs = con.prepareCall("{call deleteUser(?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, username);
		cs.setString(3, password);
		cs.execute();
	}

	static void modifyUserLogin(Connection con, String cnp, String username, String password) throws SQLException {
		CallableStatement cs = con.prepareCall("{call modifyLogin(?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, username);
		cs.setString(3, password);
		cs.execute();
	}

	static void modifyUserDatePers(Connection con, String cnp, String nume, String prenume, String adresa,
			String telefon, String email, String cont_IBAN, String nr_contract, String year, String month, String day,
			String functie) throws SQLException {
		CallableStatement cs = con.prepareCall("{call modifyDatePers(?,?,?,?,?,?,?,?,?,?)}");
		cs.setString(1, cnp);
		cs.setString(2, nume);
		cs.setString(3, prenume);
		cs.setString(4, adresa);
		cs.setString(5, telefon);
		cs.setString(6, email);
		cs.setString(7, cont_IBAN);
		cs.setString(8, nr_contract);
		cs.setString(9, year + ":" + month + ":" + day);
		cs.setString(10, functie);
		cs.execute();
	}

	static void modifyAngajat(Connection con, String cnp, Integer salariu, Integer nrOre, Integer tipOrar)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call modifyAngajat(?,?,?,?)}");
		cs.setString(1, cnp);
		cs.setInt(2, salariu);
		cs.setInt(3, nrOre);
		cs.setInt(4, tipOrar);
		cs.execute();
	}

	static void addPoliclinica(Connection con, Integer idUnit, String denumire, String adresaPoliclinica)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call addPoliclinica(?,?,?)}");
		cs.setInt(1, idUnit);
		cs.setString(2, denumire);
		cs.setString(3, adresaPoliclinica);
		cs.execute();
	}

//GRIJA!
	static void insertProgramare(com.sun.jdi.connect.spi.Connection con, String data, String startTime, String endTime,
			String CNP) throws SQLException {
		CallableStatement cs = ((Connection) con).prepareCall("{call InsertProgramare(?,?,?,?)}");
		cs.setString(1, data);
		cs.setString(2, startTime);
		cs.setString(3, endTime);
		cs.setString(4, CNP);
		cs.execute();
	}

	static ResultSet getDatePersonale(Connection con, String CNP) throws SQLException {
		String query = "select * from date_personale d where d.CNP = '" + CNP + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getIstoricPacient(Connection con, String cnpPacient) throws SQLException {
		String query = "select * from istoric_pacient d where cnp_pacient = '" + cnpPacient + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getProfitMedic(Connection con, String cnp) throws SQLException {
		CallableStatement cs = con.prepareCall("{call GetProfitMedic(?)}");
		cs.setString(1, cnp);
		cs.execute();
		return cs.getResultSet();
	}

	static ResultSet getFunctie(Connection con, String CNP, String password) throws SQLException {
		String query = "select functie from date_personale where date_personale.CNP = (select CNP from login where login.CNP= '"
				+ CNP + "' and login.pass='" + password + "')";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getProgramari(Connection con, String CNP) throws SQLException {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		String query = "select * from programare d where CNP_medic = '" + CNP + "' and data='" + date + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static void InsertIstoricPacient(Connection con, String CNP_medic, String CNP_pacient, String simptome,
			String diagnostic, String recomandari) throws SQLException {

		System.out.println(CNP_pacient);
		CallableStatement cs = con.prepareCall("{call InsertIstoricPacient(?,?,?,?,?)}");
		cs.setString(1, CNP_medic);
		cs.setString(2, CNP_pacient);
		cs.setString(3, simptome);
		cs.setString(4, diagnostic);
		cs.setString(5, recomandari);
		cs.execute();
	}

	static void InsertPacient(Connection con, String CNP, String nume, String prenume) throws SQLException {

		CallableStatement cs = con.prepareCall("{call InsertPacient(?,?,?)}");
		cs.setString(1, CNP);
		cs.setString(2, nume);
		cs.setString(3, prenume);
		cs.execute();
	}

	static ResultSet getPretServiciu(Connection con, String CNP) throws SQLException {
		String query = "select * from servicii d where CNP = '" + CNP + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getServiciiUnitate(Connection con, Integer id) throws SQLException {
		String query = " select s.nume,s.id_serv from servicii s, unit_serv us ,unitate_medicala u where u.id_unit= '"
				+ id + "' and u.id_unit=us.id_unit and s.id_serv=us.id_serv";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static String spec_serv(Connection con, Integer id_serv[], Integer nrOfIds, String data, String startT, String endT)
			throws SQLException {
		Statement stmt = con.createStatement();

		String query = " select * from med_spec where id_spec IN (Select id_spec from spec_serv where id_serv='"
				+ id_serv[0] + "') Order by med_spec.CNP";
		String q2 = "select id_spec from spec_serv where id_serv='" + id_serv[0] + "'";
		ResultSet rs2 = stmt.executeQuery(q2);
		int j = 0;
		while (rs2.next()) {
			j++;
		}
		int id = -1;
		String[] doctors = new String[10];
		String prev = "0";
		int i = 0;
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String CNP = rs.getString("CNP");
			if (CNP.contentEquals(prev) || prev.contentEquals("0"))
				i++;

			else
				i = 1;

			if (i == j) {
				id++;
				doctors[id] = CNP;
				i = 0;
			}

			prev = CNP;
		}

		for (int iterator = 1; iterator < nrOfIds; iterator++) {
			System.out.println("id_Serv:" + id_serv[iterator]);
			String query1 = " select * from med_spec where id_spec IN (Select id_spec from spec_serv where id_serv='"
					+ id_serv[iterator] + "') Order by med_spec.CNP";
			String query2 = "select id_spec from spec_serv where id_serv='" + id_serv[iterator] + "'";
			rs2 = stmt.executeQuery(query2);
			j = 0;
			while (rs2.next()) {
				j++;
				System.out.println("ID SPEC:" + rs2.getString("id_spec"));
			}
			int k = -1;

			String[] doctors2 = new String[10];
			prev = "0";
			i = 0;
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String CNP = rs.getString("CNP");
				if (CNP.contentEquals(prev) || prev.contentEquals("0"))
					i++;

				else
					i = 1;

				if (i == j) {
					k++;
					doctors2[k] = CNP;
					i = 0;
				}

				prev = CNP;
			}

			for (int y = 0; y <= k; y++)
				System.out.print(doctors2[y] + "    ");
			System.out.println();

			for (int z = 0; z <= id; z++) {
				int ok = 0;

				for (int y = 0; y <= k; y++)
					if (doctors[z].contentEquals(doctors2[y]))
						ok = 1;

				if (ok == 0)
					doctors[z] = "invalid";
			}

			for (int z = 0; z <= id; z++)
				if (doctors[z].contentEquals("invalid")) {
					for (int y = z; y < id; y++)
						doctors[z] = doctors[z + 1];
					id--;
					z--;
				}

		}

		// Verifica prima data in tabela program_ang_l daca in ziua respectiva

		System.out.println("Id-este+" + id);
		for (int z = 0; z <= id; z++) {
			System.out.println("Cnpul este:" + doctors[z] + " iar data este:" + data);
			String query3 = "select * from programare where CNP_medic='" + doctors[z] + "'and data='" + data + "'";
			rs2 = stmt.executeQuery(query3);
			int ok = 1;

			while (rs2.next()) {
				String startq;
				String endq;
				startq = rs2.getString("start_p");
				endq = rs2.getString("end_p");
				Integer startTabel = Integer
						.parseInt("" + startq.charAt(0) + startq.charAt(1) + startq.charAt(3) + startq.charAt(4));
				Integer endTabel = Integer
						.parseInt("" + endq.charAt(0) + endq.charAt(1) + endq.charAt(3) + endq.charAt(4));
				Integer startParam = Integer
						.parseInt("" + startT.charAt(0) + startT.charAt(1) + startT.charAt(3) + startT.charAt(4));
				Integer endParam = Integer
						.parseInt("" + endT.charAt(0) + endT.charAt(1) + endT.charAt(3) + endT.charAt(4));
				// System.out.println("Start t1:"+startq);
				// System.out.println("Start tparam:"+startT);

				if (startParam > startTabel && startParam < endTabel)
					ok = 0;
				if (endParam > startTabel && endParam < endTabel)
					ok = 0;
				if (startParam <= startTabel && endParam >= endTabel)
					ok = 0;

			}
			if (ok == 0)
				doctors[z] = "invalid";
		}

		for (int z = 0; z <= id; z++)
			if (doctors[z].contentEquals("invalid")) {
				for (int y = z; y < id; y++)
					doctors[z] = doctors[z + 1];
				id--;
				z--;
			}

		if (id >= 0)
			return doctors[0];
		else
			return null;

	}

	static String getName(Connection con, String CNP) throws SQLException {
		String query = "select nume from date_personale d where d.CNP = '" + CNP + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next())
			return rs.getString("nume");

		return null;
	}

	static ResultSet getSalariuAngajat(Connection con, String CNP) throws SQLException {
		String query = "select salariu_neg,numar_ore_total from angajat a where a.CNP = '" + CNP + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		return rs;
	}

	static ResultSet getProgramAngajat(Connection con, String CNP) throws SQLException {
		String query = "select * ,(select denumire from unitate_medicala u where p.id_unit=u.id_unit) as nume_unitate from program_ang_s p where p.CNP = '"
				+ CNP + "' order by p.zi,p.start_p,p.end_p";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getConcediuAngajat(Connection con, String CNP) throws SQLException {
		String query = "select * from concediu c where c.CNP = '" + CNP + "' order by c.ziua";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static void parafareRaport(Connection con, int id_istoric, String cnp_asistent) throws SQLException {
		CallableStatement cs = con.prepareCall("{call parafareRaport(?,?)}");
		cs.setInt(1, id_istoric);
		cs.setString(2, cnp_asistent);
		cs.execute();
	}

	static ResultSet isParafat(Connection con, int id_istoric) throws SQLException {
		String query = "select val_bin from raport_analize where raport_analize.id=" + id_istoric;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static void creareRaport(Connection con, int rezultat, int idIstoric) throws SQLException {
		CallableStatement cs = con.prepareCall("{call creareRaport(?,?)}");
		cs.setInt(1, idIstoric);
		cs.setInt(2, rezultat);
		cs.execute();
	}
	
	
	static ResultSet idIstoric(Connection con, String cnp) throws SQLException {
		String query = "select id_istoric from istoric_pacient where istoric_pacient.cnp_pacient='"+cnp+"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static void creareProgramUnitate(Connection con, int id_unit, String year, String month, String day, String start_p,
			String end_p) throws SQLException {
		CallableStatement cs = con.prepareCall("{call creareProgramUnitate(?,?,?,?)}");
		cs.setInt(1, id_unit);
		cs.setString(2, year + ":" + month + ":" + day);
		cs.setString(3, start_p);
		cs.setString(4, end_p);
		cs.execute();
	}

	static void insertProgramare(Connection con, String CNP_medic, String CNP_pacient, String data, String start_p,
			String end_p, Integer durata, String idUnit) throws SQLException {
		CallableStatement cs = con.prepareCall("{call insertProgramare(?,?,?,?,?,?,?)}");
		cs.setString(1, CNP_medic);
		cs.setString(2, CNP_pacient);
		cs.setString(3, data);
		cs.setString(4, start_p + ":00");
		cs.setString(5, end_p + ":00");
		cs.setInt(6, durata);
		cs.setString(7, (idUnit));
		cs.execute();
	}

	static ResultSet getFunctieBack(Connection con, String cnp) throws SQLException {
		String query = "select functie from date_personale where date_personale.CNP = (select CNP from login where login.CNP= '"
				+ cnp + "')";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getServicii(Connection con, String nume) throws SQLException {
		String query = "select * from servicii where servicii.nume='" + nume + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static String getNumeSpecialitate(Connection con, String id) throws SQLException {
		String query = "select nume from specialitate s where s.id_spec = '" + id + "' ";
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			return rs.getString("nume");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static String getIdSpecialitate(Connection con, String nume) {
		String query = "select id_spec from specialitate s where s.nume = '" + nume + "' ";
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			return rs.getString("id_spec");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static String getIdUnitate(Connection con, String nume) {
		String query = "select id_unit from unitate_medicala u where u.denumire = '" + nume + "' ";
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			return rs.getString("id_unit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static String getNumeUnitate(Connection con, String id) {
		String query = "select denumire from unitate_medicala u where u.id_unit = '" + id + "' ";
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			return rs.getString("denumire");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static String getNameUnitate(Connection con, String unit) throws SQLException {
		String query = "select denumire from unitate_medicala d where d.id_unit = '" + unit + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			return rs.getString("denumire");
		}
		return null;

	}

	static ResultSet getAllSpecialitateCNP(Connection con, String CNP) throws SQLException {
		String query = "select ms.id_spec from  med_spec ms where ms.CNP = '" + CNP + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet getAllUnitateCNP(Connection con, String CNP) throws SQLException {
		String query = "select ua.id_unit from unit_ang ua where ua.CNP = '" + CNP + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static String getUnitateNume(Connection con, String id_unit) {
		String query = "select  denumire from unitate_medicala u where u.id_unit = '" + id_unit + "';";
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next() == false)
				return null;
			return rs.getString("denumire");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static String getProfitUnitateFara(Connection con, String id_unit) throws SQLException {
		String query = "select  sum(a.salariu_neg*ua.ore) as profit from unit_ang ua,angajat a where a.CNP = ua.CNP;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		return rs.getString("profit");
	}

	static void InsertProgramS(Connection con, String start_p, String end_p, Integer zi, String CNP, Integer id_unit)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call InsertProgramS(?,?,?,?,?)}");
		cs.setString(1, start_p);
		cs.setString(2, end_p);
		cs.setInt(3, zi);
		cs.setString(4, CNP);
		cs.setInt(5, id_unit);

		cs.execute();
	}

	static ResultSet getSalariuPerUnitate(Connection con, String CNP, String unit) throws SQLException {
		CallableStatement cs = con.prepareCall("{call GetProfitMedicUnitate(?,?)}");
		cs.setString(1, CNP);
		cs.setString(2, unit);

		cs.execute();
		ResultSet rs = cs.getResultSet();
		return rs;
	}

	static ResultSet getSalariuPerSpecializare(Connection con, String CNP, String unit) throws SQLException {
		CallableStatement cs = con.prepareCall("{call GetProfitMedicSpecialitate(?,?)}");
		cs.setString(1, CNP);
		cs.setString(2, unit);

		cs.execute();
		ResultSet rs = cs.getResultSet();
		return rs;
	}

	static ResultSet getProfitUnitate(Connection con, String unit) throws SQLException {
		CallableStatement cs = con.prepareCall("{call GetProfitUnitate(?)}");
		cs.setString(1, unit);

		cs.execute();
		ResultSet rs = cs.getResultSet();
		return rs;
	}

	static void UpdateProgramS(Connection con, String start_p, String end_p, Integer zi, String CNP, Integer id_unit,
			String newstart_p, String newend_p, Integer newid_unit) throws SQLException {
		CallableStatement cs = con.prepareCall("{call UpdateProgramS(?,?,?,?,?,?,?,?)}");
		cs.setString(1, start_p);
		cs.setString(2, end_p);
		cs.setInt(3, zi);
		cs.setString(4, CNP);
		cs.setInt(5, id_unit);
		cs.setString(6, newstart_p);
		cs.setString(7, newend_p);
		cs.setInt(8, newid_unit);
		cs.execute();
	}

	static void DeleteProgramS(Connection con, int zi, String start_p, String end_p, int id_unit, String CNP)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call DeletePRogramS(?,?,?,?,?)}");
		cs.setInt(1, zi);
		cs.setString(2, start_p);
		cs.setString(3, end_p);
		cs.setInt(4, id_unit);
		cs.setString(5, CNP);
		cs.execute();

	}

	static void DeleteConcediu(Connection con, String ziua, String CNP) throws SQLException {
		CallableStatement cs = con.prepareCall("{call DeleteConcediu(?,?)}");
		cs.setString(1, CNP);
		cs.setString(2, ziua);
		cs.execute();
	}

	static void InsertConcediu(Connection con, String year, String month, String day, String CNP) throws SQLException {
		CallableStatement cs = con.prepareCall("{call InsertConcediu(?,?)}");
		cs.setString(1, year + ":" + month + ":" + day);
		cs.setString(2, CNP);
		cs.execute();
	}

	static void UpdateConcediu(Connection con, String year, String month, String day, String CNP, String newYear,
			String newMonth, String newDay) throws SQLException {
		CallableStatement cs = con.prepareCall("{call  UpdateConcediu(?,?,?)}");
		System.out.println(year + ":" + month + ":" + day);
		System.out.println(newYear + ":" + newMonth + ":" + newDay);
		cs.setString(1, year + ":" + month + ":" + day);
		cs.setString(2, CNP);
		cs.setString(3, newYear + ":" + newMonth + ":" + newDay);
		cs.execute();
	}

	static ResultSet GetProgramPerZi(Connection con, Integer zi, String CNP) throws SQLException {
		String query = "select start_p,end_p,id_unit from program_ang_s p where p.CNP = '" + CNP + "' and p.zi = " + zi;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet searchId(Connection con, String nume, String prenume, String functie) throws SQLException {
		String query = "select CNP from date_personale d where d.nume = '" + nume + "' and d.prenume = '" + prenume
				+ "' and d.functie= '" + functie + "'";
		Statement stmt = con.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	static ResultSet searchAngajatConcediu(Connection con, String nume, String prenume, String functie)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call SearchAngajatConcediu(?,?,?)}");
		cs.setString(1, nume);
		cs.setString(2, prenume);
		cs.setString(3, functie);
		if (!cs.execute()) {
			System.out.println("Error when I tried to query");
			return null;
		}
		ResultSet rs = cs.getResultSet();
		return rs;
	}

	static ResultSet searchAngajatProgram(Connection con, String nume, String prenume, String functie)
			throws SQLException {
		CallableStatement cs = con.prepareCall("{call SearchAngajatProgram(?,?,?)}");
		cs.setString(1, nume);
		cs.setString(2, prenume);
		cs.setString(3, functie);
		if (!cs.execute()) {
			System.out.println("Error when I tried to query");
			return null;
		}
		ResultSet rs = cs.getResultSet();
		return rs;
	}
	
	static ResultSet estePacient(Connection con, String cnp) throws SQLException {
		String query = "select nume from pacient where pacient.cnp = '" + cnp + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	
	static void creareRaport(Connection con, int rezultat, String cnp_pacient) throws SQLException {
		CallableStatement cs = con.prepareCall("{call creareRaport(?,?)}");
		cs.setInt(1, rezultat);
		cs.setString(2, cnp_pacient);
		cs.execute();
	}

}
