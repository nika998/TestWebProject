package it.engineering.web.dao.jdbctemplateimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import it.engineering.web.dao.ManufacturerDao;
import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;

@Component(value = "manufacturerJdbcTemplate")
public class ManufacturerJDBCTemplateImpl implements ManufacturerDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ManufacturerMapper manufacturerMapper;

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
		return jdbcTemplate.query(query, manufacturerMapper);
	}
    
	@Component
	class ManufacturerMapper implements RowMapper<Proizvodjac> {
        
		@Autowired
		CityJDBCTemplateImpl cityJDBCTemplateImpl;

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
