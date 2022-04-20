package it.engineering.web.dao.jdbctemplateimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import it.engineering.web.dao.ManufacturerDao;
import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;

public class ManufacturerJDBCTemplateImpl implements ManufacturerDao {

	private JdbcTemplate jdbcTemplate;
	private DataSourceFactory dataSourceFactory;

	public ManufacturerJDBCTemplateImpl() {
		dataSourceFactory = new DataSourceFactory();
		DataSource dataSource = dataSourceFactory.getDataSource();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void add(Proizvodjac manufacturer) {
		System.out.println("Add manufacturer");
		jdbcTemplate.update("INSERT INTO proizvodjac(maticnibroj,pib,adresa,mesto) VALUES(?,?,?,?)",
				manufacturer.getMaticniBroj(), manufacturer.getPib(), manufacturer.getAdresa(),
				manufacturer.getMesto().getPttBroj());

	}

	@Override
	public void update(Proizvodjac manufacturer) {
		System.out.println("Update city");
		jdbcTemplate.update("UPDATE proizvodjac SET pib = ?, adresa = ?, mesto = ? WHERE maticniBroj = ?", manufacturer.getPib(),
				manufacturer.getAdresa(), manufacturer.getMesto().getPttBroj(), manufacturer.getMaticniBroj());

	}

	@Override
	public void remove(Proizvodjac manufacturer) {
		System.out.println("Delete manufacturer");
		jdbcTemplate.update("DELETE FROM proizvodjac WHERE maticniBroj = ?", manufacturer.getMaticniBroj());

	}

	@Override
	public List<Proizvodjac> getAll() {
		System.out.println("Get all manufacturers");
		String query = "select * from Proizvodjac";
		return jdbcTemplate.query(query, new ManufacturerMapper());
	}

	class ManufacturerMapper implements RowMapper<Proizvodjac> {

		CityJDBCTemplateImpl cityJDBCTemplateImpl = new CityJDBCTemplateImpl();

		@Override
		public Proizvodjac mapRow(ResultSet rs, int rowNum) throws SQLException {
			Proizvodjac manufacturer = new Proizvodjac();
			manufacturer.setMaticniBroj(rs.getString("maticniBroj"));
			manufacturer.setPib(rs.getString("pib"));
			manufacturer.setAdresa(rs.getString("adresa"));
			Mesto mesto = cityJDBCTemplateImpl.findByID(rs.getInt("mesto"));
			manufacturer.setMesto(mesto);

			return manufacturer;
		}

	}

}
