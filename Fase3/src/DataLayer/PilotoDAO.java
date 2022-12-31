package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import BussinessLayer.SubPiloto.Piloto;

public class PilotoDAO implements Map<String,Piloto>{
	private static PilotoDAO singleton = null;

	private PilotoDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
             String sql = "CREATE TABLE IF NOT EXISTS arestas (" +
                     "NomePiloto varchar(10) NOT NULL PRIMARY KEY," +
                     "Cts DOUBLE NOT NULL," +
                     "Sva DOUBLE NOT NULL," +
                     "Nacionalidade varchar(45) NOT NULL";
             stm.executeUpdate(sql);
			;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

	// Implementação do padrão Singleton
    // devolve a instância única desta classe
    public static PilotoDAO getInstance() {
        if (PilotoDAO.singleton == null) {
            PilotoDAO.singleton = new PilotoDAO();
        }
        return PilotoDAO.singleton;
    }

	@Override
	// Este método devolve o número de entradas na tabela na base de dados
	public int size() {
		int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("######")) {	// falta adicionar isto
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return i;
	}

	@Override
	// Método que devolve se uma tabela está vazia ou não
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	// Método que devolve se o código de um dado  se encontra registada na base de dados
    // Lança exceção caso ocorra algum problema na procura.
	public boolean containsKey(Object key) {
		boolean r;
        try	(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
			Statement stm = conn.createStatement();
			ResultSet rs =
			stm.executeQuery("'"+key.toString()+"'")) {	// falta adicionar cenas
            r = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
	}

	@Override
	// Método que devolve se um dado cricuito se encontra registada na base de dados
	public boolean containsValue(Object value) {
		Piloto a = (Piloto) value;
        return this.containsKey(a.getNomePiloto());
	}

	@Override
	// Método que devolve o piloto cujo nome é o passado como argumento
    // Lança exceção caso haja algum problema na procura na base de dados
	public Piloto get(Object key) {
		Piloto a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("'"+key+"'")) {	// falta adicionar cenas
            if (rs.next()) {  // A chave existe na tabela
                // TODO
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return a;
	}

	@Override
	// Adiconar entrada á tabela dos pilotos na base de dados. O nome do piloto é a identificação do objeto na tabela
    // É lançada exceção caso haja algum problema relativo á database
	public Piloto put(String key, Piloto p) {
		Piloto res = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            if(this.containsKey(key)){
                res = this.get(key);
            }
            else {
                // Actualizar o aluno
                stm.executeUpdate(		// falta adicionar cenas
                        "INSERT INTO arestas VALUES ('" + p.getNomePiloto() + "', '" + p.getCts() + "', '" + p.getSva() + "', '" + p.getNacionalidade() + "') " );
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
	}

	@Override
	// Método que remove da tabela dos pilotos na database, o cicuito cujo nome é passado como argumento.
    // É necessário por null em todas as referencias do piloto removido em outras tabelas
    // Lançada exceção caso haja algum problema na base de dados
	public Piloto remove(Object key) {
		Piloto t = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            // stm.executeUpdate("DELETE FROM arestas WHERE Codigo='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return t;
	}

	@Override
	//Método que adiciona de uma unica vez vários pilotos à tabela na base de dados
	public void putAll(Map<? extends String, ? extends Piloto> m) {
		for(Piloto t : m.values()) {
            this.put(t.getNomePiloto(), t);
        }		
	}

	@Override
	// Método que elimina todas as entradas na tabela pilotos.
    // É necessário por null em todas as referencias do piloto removido em outras tabelas
    // É lançada exceção caso haja algum problema com a base de dados
	public void clear() {
		try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {	// falta adicionar cenas
            // stm.execute("UPDATE robots SET Rota=NULL");
            // stm.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            // stm.executeUpdate("TRUNCATE rotas");
            // stm.executeUpdate("TRUNCATE arestasRotas");
            // stm.executeUpdate("TRUNCATE arestas");
            // stm.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
	}

	@Override
	// Método que devolve um set com todos os nomes de pilotos presentes na base de dados
    // É lançada exceção caso haja algum problema com a base de dados
	public Set<String> keySet() {
		Set<String> col = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("")) { // "SELECT Codigo FROM arestas"
            while (rs.next()) {
                // col.add(rs.getString("Codigo")); // falta adicionar cenas acho eu
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return col;
	}

	@Override
	// Método que devolve uma collection com todos os objetos pilotos presentes na base de dados
    // É lançada exceção caso haja algum problema com a base de dados
	public Collection<Piloto> values() {
		Collection<Piloto> col = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("")) {	// "SELECT Codigo FROM arestas"
            while (rs.next()) {
                // col.add(this.get(rs.getString("Codigo"))); // falta adicionar cenas acho eu
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return col;
	}

	@Override
	// Método que devolve um set com todos "pares" formados pelo nome do piloto e o objeto piloto correspondente
    // É lançada exceção caso haja algum problema com a base de dados
	public Set<Entry<String, Piloto>> entrySet() {
		Map.Entry<String,Piloto> entry;
        HashSet<Map.Entry<String, Piloto>> col = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("")) { // "SELECT Codigo FROM arestas"
            while (rs.next()) {
                entry = null; // new AbstractMap.SimpleEntry<>(rs.getString("Codigo"),this.get(rs.getString("Codigo"))); // falta cenas
                col.add(entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return col;
	}
}
