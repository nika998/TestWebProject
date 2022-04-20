package it.engineering.web.dao.jdbctemplateimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import it.engineering.web.dao.CityDao;
import it.engineering.web.domain.Mesto;

public class CityJDBCTemplateImpl implements CityDao {

	private JdbcTemplate jdbcTemplate;
	private DataSourceFactory dataSourceFactory;

	public CityJDBCTemplateImpl() {
		dataSourceFactory = new DataSourceFactory();
		DataSource dataSource = dataSourceFactory.getDataSource();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void add(Mesto city) {
		System.out.println("Add city");
		jdbcTemplate.update("INSERT INTO mesto(pttBroj, Naziv) VALUES(?,?)", city.getPttBroj(), city.getNaziv());

	}

	@Override
	public void update(Mesto city) {
		System.out.println("Update city");
		jdbcTemplate.update("UPDATE mesto SET Naziv = ? WHERE pttBroj = ?", city.getNaziv(), city.getPttBroj());

	}

	@Override
	public void remove(Mesto city) {
		System.out.println("Delete city");
		jdbcTemplate.update("DELETE FROM mesto WHERE WHERE pttBroj = ?", city.getPttBroj());

	}

	@SuppressWarnings("deprecation")
	@Override
	public Mesto findByID(int pttBroj) {
		System.out.println("Get all cities");
		String query = "select * from mesto where pttBroj = ?";
		Object[] args = { pttBroj };
		return jdbcTemplate.queryForObject(query, args, new CityMapper());
	}

	@Override
	public List<Mesto> getAll() {
		String query = "select * from Mesto";
		return jdbcTemplate.query(query, new CityMapper());

	}

	class CityMapper implements RowMapper<Mesto> {

		@Override
		public Mesto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Mesto city = new Mesto();
			city.setPttBroj(rs.getInt("pttBroj"));
			city.setNaziv(rs.getString("Naziv"));

			return city;
		}

	}

}
