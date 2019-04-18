const $educationLevel = $('#education-level-select');
const $province = $('#province-select');
const $area = $('#area-select');

const corsProxy = 'https://cors-anywhere.herokuapp.com/';

const model = {
  selected_province_id: null,
};

const defaultConfigEducationLevel = {
  language: 'id',
  placeholder: 'Pilih salah satu',
};

const defaultConfigProvince = {
  ajax: {
    url: provinceUrl,
    delay: 500,
    dataType: 'json',
    processResults: response => {
      const province = response.map(currentValue => {
        return {
          id: currentValue.id,
          text: currentValue.name,
        };
      });
      return {
        // param results is required to parse obj to select2
        results: province,
      }
    },
  },
  language: 'id',
  placeholder: 'Pilih salah satu',
  width: '25%',
};
const defaultConfigArea = {
  ajax: {
    url: corsProxy + 'https://api.rajaongkir.com/starter/city',
    delay: 500,
    headers: {
      key: 'c28f1db1a7340c866d915387d5302123',
    },
    data: () => {
      if (model.selected_province_id) {
        return {
          province: model.selected_province_id,
        };
      }
      return '';
    },
    dataType: 'json',
    processResults: response => {
      const { results } = response.rajaongkir;
      const city = $.map(results, (obj) => {
        return {
          id: Number(obj.city_id),
          text: obj.city_name,
        }
      });
      return {
        // param results is required to parse obj to select2
        results: city,
      }
    },
  },
  data: {id: null, text: null},
  disabled: 'true',
  language: 'id',
  placeholder: 'Pilih provinsi dahulu',
  width: '25%',
};

function initSelect2() {
  $educationLevel.select2(defaultConfigEducationLevel);
  $province.select2(defaultConfigProvince);
  $area.select2(defaultConfigArea);
}

function resetAreaSelect() {
  $area.val(null).trigger('change');
  $area.select2(defaultConfigArea);
  $area.prop('disabled', false);
}

document.addEventListener('DOMContentLoaded', function() {
  initSelect2();
  $province.on('select2:select', (e) => {
    const { data } = e.params;
    model.selected_province_id = data.id;
    resetAreaSelect();
  });
});
